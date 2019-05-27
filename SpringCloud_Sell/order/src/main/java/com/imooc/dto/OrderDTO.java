package com.imooc.dto;

import com.imooc.dataobject.OrderDetail;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jason on 2019/4/23.
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    /** 买家地址.  */
    private String buyerAddress;

    /** 买家微信Openid.  */
    private String buyerOpenid;

    /** 买家订单总金额.  */
    private BigDecimal orderAmount;

    /** 订单状态，默认为0新下单.  */
    private Integer orderStatus ;

    /** 支付状态，默认为0未支付.  */
    private Integer payStatus ;

    private List<OrderDetail> orderDetailList;
}
