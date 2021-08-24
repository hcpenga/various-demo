package com.example.variousdemo.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className: NeoSender2
 * @description:
 * @created: 2021/08/24 13:57
 */
@Component
public class NeoSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i){
        String context = "spring boot neo queue " + " **** " + i;
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("neo",context);
    }
}
