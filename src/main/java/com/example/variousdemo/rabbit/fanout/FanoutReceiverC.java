package com.example.variousdemo.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: FanoutReceiverC
 * @description:
 * @created: 2021/08/23 16:57
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String message){
        System.out.println("fanout Receiver C:" + message);
    }
}
