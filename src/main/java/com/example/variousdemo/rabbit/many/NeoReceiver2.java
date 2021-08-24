package com.example.variousdemo.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: NeoReceiver2
 * @description:
 * @created: 2021/08/24 14:00
 */
@Component
@RabbitListener(queues = "neo")
public class NeoReceiver2 {

    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver2 :" + message);
    }
}
