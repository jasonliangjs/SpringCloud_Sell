package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * Created by jason on 2019/4/24.
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }
}
