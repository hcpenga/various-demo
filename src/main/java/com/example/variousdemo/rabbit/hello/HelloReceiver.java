package com.example.variousdemo.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: HelloReceiver
 * @description:
 * @created: 2021/08/24 13:49
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver : " + hello);
    }
}
