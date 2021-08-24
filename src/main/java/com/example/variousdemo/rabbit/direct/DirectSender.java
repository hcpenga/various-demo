package com.example.variousdemo.rabbit.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className: DirectSender
 * @description:
 * @created: 2021/08/24 09:56
 */
@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send(){
        String context = "hi , i am direct";
        System.out.println("Sender");
        this.rabbitmqTemplate.convertAndSend("directExchange","direct",context);
    }
}
