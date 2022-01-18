package com.example.variousdemo.controller;

import com.example.variousdemo.annotation.hcLog;
import com.example.variousdemo.entity.User;
import com.example.variousdemo.helper.TestHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @className: HelloController
 * @description: Hello World
 * @created: 2021/07/01 20:10
 */
@Api(tags = "测试模块")
@RestController
@RequestMapping("/helloController")
public class HelloController {

    Logger logger = Logger.getLogger(HelloController.class);
    @Autowired
    private TestHelper testHelper;

    @hcLog
    @ApiOperation("第一个测试用例")
    @GetMapping("/hello")
    public String hello(User user){
        MDC.put("hcReqId", UUID.randomUUID().toString());
        logger.info("Hello world one");
        return "Hello world one";
    }

    @GetMapping("/hello2")
    public String hello2(){
        logger.info("Hello world two");
        logger.info("Hello world two second");
        if(true){
            throw new RuntimeException("Value for condition cannot be null");
        }
        return "Hello world two thrid";
    }

    @GetMapping("/getValue")
    public String getValue(){
        return (String) testHelper.getTestMap().get("one");
    }
}
