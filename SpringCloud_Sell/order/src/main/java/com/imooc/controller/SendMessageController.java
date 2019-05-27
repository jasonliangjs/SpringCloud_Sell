package com.imooc.controller;
import java.util.Date;
import com.imooc.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.support.MessageBuilder;
/**
 * 消息的发送
 * Created by jason on 2019/4/29.
 */
@RestController
public class SendMessageController {
    //1.引入StreamClient接口
    @Autowired
    private StreamClient streamClient;

    //2.发送
    @GetMapping("/sendMessage")
    public void process(){
        String message = "now " + new Date();
        boolean b = streamClient.output().send(MessageBuilder.withPayload(message).build());
    }
}









