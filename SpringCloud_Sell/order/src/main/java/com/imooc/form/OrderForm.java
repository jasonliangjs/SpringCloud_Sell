package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by jason on 2019/4/24.
 */
@Data
public class OrderForm {
    /**买家姓名.*/
    @NotEmpty(message = "姓名必填")
    private String name;

    /**手机号码.*/
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**地址.*/
    @NotEmpty(message = "地址必填")
    private String address;

    /**微信openid.*/
    @NotEmpty(message = "微信openid必填")
    private String openid;

    /**购物车.*/
    @NotEmpty(message = "购物车必填")
    private String items;
}
