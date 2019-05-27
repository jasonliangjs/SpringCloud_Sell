package com.imooc.utils;

import com.imooc.vo.ResultVO;

/**
 * Created by jason on 2019/4/23.
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
