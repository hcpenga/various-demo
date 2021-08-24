package com.example.variousdemo.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: NeoReceiver
 * @description:
 * @created: 2021/08/24 13:58
 */
@Component
@RabbitListener(queues = "neo")
public class NeoReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver 1 :" + message);
    }
}
