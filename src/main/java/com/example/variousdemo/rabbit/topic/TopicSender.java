package com.example.variousdemo.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @className: TopicSender
 * @description:
 * @created: 2021/08/23 17:29
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hi, i am message all";
        System.out.println("Sender");
        this.rabbitTemplate.convertAndSend("topicExChange","topic.1",context);
    }

    public void send1(){
        String context = "hi, i am message 1";
        System.out.println("Sender");
        this.rabbitTemplate.convertAndSend("topicExchange","topic.message",context);
    }

    public void send2(){
        String context = "hi, i am messages 2";
        System.out.println("Sender");
        this.rabbitTemplate.convertAndSend("topicExchange","topic.messages",context);
    }

}
