package com.imooc.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 * Created by jason on 2019/4/23.
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
