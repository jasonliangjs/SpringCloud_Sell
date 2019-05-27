package com.imooc.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by jason on 2019/4/29.
 */
public interface StreamClient {

    @Input("myMessage22")
    SubscribableChannel input();

    @Output("myMessage23")
    MessageChannel output();
}

//    String INPUT = "myMessage";
//
//    String INPUT2 = "myMessage2";
//
//    @Input(StreamClient.INPUT)
//    SubscribableChannel input();
//
//    @Output(StreamClient.INPUT2)
//    MessageChannel output();