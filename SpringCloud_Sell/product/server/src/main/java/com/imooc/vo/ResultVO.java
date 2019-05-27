package com.imooc.vo;

import lombok.Data;

import java.util.List;

/**
 * http请求返回的最外层对象
 * Created by jason on 2019/4/23.
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
