package com.example.variousdemo.rabbitmq;

import com.example.variousdemo.rabbit.hello.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className: HelloTest
 * @description:
 * @created: 2021/08/24 13:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {
    private String test;
    @Autowired
    private HelloSender helloSender;

    @Test
    public void HelloSender(){
        helloSender.send();
    }
}
