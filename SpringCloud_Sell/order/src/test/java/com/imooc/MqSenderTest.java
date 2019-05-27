package com.imooc;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static java.time.LocalDateTime.now;

/**
 * 发送mq消息测试
 * Created by jason on 2019/4/29.
 */
@Component
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
//        amqpTemplate.convertAndSend("myQueue", "now:" + now());
        amqpTemplate.convertAndSend("myQueue3","NOW  "+ new Date());
    }

    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","PC","NOW  "+ new Date());
    }

}
