package com.example.variousdemo.rabbit.direct;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: DirectReceiver
 * @description:
 * @created: 2021/08/24 13:40
 */
@Component
@RabbitListener(queues = "direct")
public class DirectReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("DirectReceiver :" + message);
    }
}
