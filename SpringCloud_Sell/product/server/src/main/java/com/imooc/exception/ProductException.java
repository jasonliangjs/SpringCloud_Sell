package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created by jason on 2019/4/25.
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
