package com.example.variousdemo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloController
 * @description: Hello World
 * @created: 2021/07/01 20:10
 */
@RestController
@RequestMapping("/helloController")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
