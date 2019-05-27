package com.imooc.VO;

import lombok.Data;

/**
 * Created by jason on 2019/4/24.
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
