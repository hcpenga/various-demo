package com.example.variousdemo.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: TopicReceiver1
 * @description:
 * @created: 2021/08/24 09:21
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String messsage){
        System.out.println("Topic Receiver2: " + messsage);
    }
}
