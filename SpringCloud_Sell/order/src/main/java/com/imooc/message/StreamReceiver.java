package com.imooc.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 消息的接收
 * Created by jason on 2019/4/29.
 */
@Component
@Slf4j
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener("myMessage22")
    public void process(Object message){
        log.info("StreamReceiver: {}", message);

    }
}
