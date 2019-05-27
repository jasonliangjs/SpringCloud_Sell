package com.imooc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
//    @HystrixCommand

    //超时配置
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                    , value = "3000")
    })*/

    //服务熔断
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled",value="true"), //设置熔断
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),//设置最小请求数
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),//设置休眠时间窗口
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="60")//设置错误百分比
//    })

    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("num") Integer num){
        if(num % 2 == 0 ){
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8005/product/listForOrder",
                Arrays.asList("157875196366160022"),String.class);
    }
    private String defaultFallback() {
        return "default message : 太拥挤请稍后再试！！";
    }

    private String fallback(){
        return "太拥挤请稍后再试！！";
    }


}
