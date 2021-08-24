package com.example.variousdemo.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: FanoutReceiverA
 * @description:
 * @created: 2021/08/23 16:52
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String message){
        System.out.println("fanout Receiver A :" + message);
    }
}
