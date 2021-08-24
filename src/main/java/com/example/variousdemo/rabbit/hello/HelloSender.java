package com.example.variousdemo.rabbit.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @className: HelloSender
 * @description:
 * @created: 2021/08/24 13:47
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello" + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }
}
