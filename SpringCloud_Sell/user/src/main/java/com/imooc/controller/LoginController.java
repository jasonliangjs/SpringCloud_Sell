package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.constant.CookieConstant;
import com.imooc.constant.RedisConstant;
import com.imooc.dataobject.UserInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.enums.RoleEnum;
import com.imooc.service.UserService;
import com.imooc.utils.CookieUtil;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by jason on 2019/5/1.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 买家登录
     * @param openid
     * @param response 需要向cookie中写 所以用到response
     * @return
     *
     * 买家端是在cookie写入openid
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid,
                          HttpServletResponse response) {
        //1.获得的openid和数据库中的数据是否进行匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if(userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        //2.判断角色
        if (RoleEnum.BUYER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3cookie中设置openid=abc
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);

        return ResultVOUtil.success();
    }

    /**
     * 卖家登录
     * @param openid
     * @param response
     * @return
     *
     * 卖家端是在cookie中写入token，然后在redis中写入token_uuid
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        //5.判断是否已经登录
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(cookie != null &&
                !StringUtils.isEmpty(redisTemplate.opsForValue()
                        .get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue()))
                )
                ){
            return ResultVOUtil.success();
        }
        //1.获得的openid和数据库中的数据是否进行匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if(userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        //2.判断角色
        if (RoleEnum.SELLER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        //3. redis中写入key=UUID,value=xyz
        //redis中key设置为"token_uuid"形式
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),
                openid, expire, TimeUnit.SECONDS);
        //4.cookie中设置token_uuid
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        return ResultVOUtil.success();
    }
}
