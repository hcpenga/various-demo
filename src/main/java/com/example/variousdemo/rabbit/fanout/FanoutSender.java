package com.example.variousdemo.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className: FanoutSender
 * @description:
 * @created: 2021/08/23 16:47
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "this is a fanout msg";
        System.out.println("Sender:"+context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","",context);
    }
}
