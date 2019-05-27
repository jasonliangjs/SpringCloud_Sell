package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Created by jason on 2019/4/23.
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单（只能卖家来操作）
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
