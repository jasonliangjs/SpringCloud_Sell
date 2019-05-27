package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created by jason on 2019/4/24.
 */
public class OrderException extends RuntimeException {

    //定义一个错误码
    private Integer code;

    public OrderException(Integer code, String message) {
        //来自于RuntimeException中的方法
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
