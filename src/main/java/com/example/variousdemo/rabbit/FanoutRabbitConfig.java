package com.example.variousdemo.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @className: FanoutRabbitConfig
 * @description:
 * @created: 2021/08/23 16:30
 */
@Configuration
public class FanoutRabbitConfig {

    /**
     *  创建三个队列 ：fanout.A   fanout.B  fanout.C
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */

    //定义队列A
    @Bean
    public Queue AMessage(){
        return new Queue("fanout.A");
    }

    //定义队列B
    @Bean
    public Queue BMessage(){
        return new Queue("fanout.B");
    }

    //定义队列C
    @Bean
    public Queue CMessage(){
        return new Queue("fanout.C");
    }

    //HCTest--定义消息发送
    @Bean
    public Queue QQMessage(){
        return new Queue("fanout.QQMessage");
    }
    //定义交换机
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    //绑定
    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    //绑定
    @Bean
    Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    //绑定
    @Bean
    Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

    //绑定
    @Bean
    Binding bindingExchangeQQMessage(Queue QQMessage,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(QQMessage).to(fanoutExchange);
    }
}
