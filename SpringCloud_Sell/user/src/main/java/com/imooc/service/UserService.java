package com.imooc.service;

import com.imooc.dataobject.UserInfo;

/**
 * Created by jason on 2019/5/1.
 */
public interface UserService {

    /**
     *  通过openid来进行查询
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
