package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jason on 2019/4/23.
 */
@Data
@Entity
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单id */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称 */
    private String productName;

    private BigDecimal productPrice;

    /** 商品数量. */
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;

    /** 创建时间. */
    private Date createTime;

    /** 修改时间. */
    private Date updateTime;

}
