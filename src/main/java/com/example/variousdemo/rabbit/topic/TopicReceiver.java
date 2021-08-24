package com.example.variousdemo.rabbit.topic;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @className: TopicReceiver
 * @description:
 * @created: 2021/08/24 09:19
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("Topic Receiver1 :" + message);
    }

}
