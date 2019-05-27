package com.imooc.repository;

import com.imooc.OrderApplicationTests;
import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by jason on 2019/4/23.
 */
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests{

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("149213");
        orderDetail.setOrderId("12345");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }


    @Test
    public void testFind(){
        List<OrderDetail> byOrderId = orderDetailRepository.findByOrderId("1234567");
        Assert.assertTrue(byOrderId != null);
        List<String> list = byOrderId.stream().map(e -> e.getDetailId()).collect(Collectors.toList());
        System.out.println(list);
    }
}