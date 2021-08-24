package com.example.variousdemo.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: FanoutReceiverB
 * @description:
 * @created: 2021/08/23 16:54
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String message){
        System.out.println("fanout Receiver B:" + message);
    }
}
