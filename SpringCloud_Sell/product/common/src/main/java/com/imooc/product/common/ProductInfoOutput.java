package com.imooc.product.common;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfoOutput {

    private String productId;

    /** 名字 **/
    private String productName;

    /** 单价 **/
    private BigDecimal productPrice;

    /** 库存 **/
    private Integer productStock;

    /** 描述 **/
    private String productDescription;

    private String productIcon;

    /**商品状态,0正常 1下架**/

    private Integer productStatus;


    /** 类目编号 **/
    private Integer categoryType;
}
