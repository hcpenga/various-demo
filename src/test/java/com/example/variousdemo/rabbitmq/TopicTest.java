package com.example.variousdemo.rabbitmq;

import com.example.variousdemo.rabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className: TopicTest
 * @description:
 * @created: 2021/08/24 09:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicSender sender;

    @Test
    public void topicSender(){
        sender.send();
    }

    @Test
    public void topicSender1(){
        sender.send1();
    }

    @Test
    public void topicSender2(){
        sender.send2();
    }
}
