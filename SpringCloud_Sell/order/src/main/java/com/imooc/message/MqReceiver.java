package com.imooc.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受mq消息
 * Created by jason on 2019/4/29.
 */
@Slf4j
@Component
public class MqReceiver {

//    @RabbitListener(queues = "myQueue")
//    2.自动创建队列 @RabbitListener(queuesToDeclare = @Queue("myQueue233"))
//    3.自动创建，exchange和queue 绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue3"),
            exchange = @Exchange("myExchange3")))
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }

    /**
     * 数码供应商 服务接受消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "PC",
            value = @Queue("my-PCOrder")

    ))
    public void processPC(String message){
        log.info("MqPC-Receiver: {}", message);
    }

    /**
     * 水果供应商 服务接受消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "Fruit",
            value = @Queue("my-FruitOrder")
    ))
    public void processFruit(String message) {
        log.info("MqFruit-Receiver: {}", message);
    }
}




















