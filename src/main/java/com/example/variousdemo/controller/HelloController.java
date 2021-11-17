package com.example.variousdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloController
 * @description: Hello World
 * @created: 2021/07/01 20:10
 */
@Api(tags = "测试模块")
@RestController
@RequestMapping("/helloController")
public class HelloController {

    @ApiOperation("第一个测试用例")
    @GetMapping("/hello")
    public String hello(){
        System.out.println("sc1");
        System.out.println("第二次提交");
        return "welcome to myasssa wssorld";
    }

}
