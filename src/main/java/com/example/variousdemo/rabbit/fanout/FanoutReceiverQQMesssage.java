package com.example.variousdemo.rabbit.fanout;

import com.example.variousdemo.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className: FanoutReceiverQQMesssage
 * @description:
 * @created: 2021/08/26 13:47
 */
@Component
@RabbitListener(queues = "fanout.QQMessage")
public class FanoutReceiverQQMesssage {

    @Autowired
    private MailService mailService;

    @RabbitHandler
    public void sendQQmessage(String message){
        mailService.sendSimpleMail("295836675@qq.com","消息中间件发送","测试消息中间件"+message);

    }
}
