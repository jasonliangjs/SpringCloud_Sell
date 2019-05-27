package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jason on 2019/4/24.
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is product's msg";
    }
}
