package com.example.variousdemo.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: DirectRabbitConfig
 * @description:
 * @created: 2021/08/24 09:49
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue directQueue(){
        return new Queue("direct");
    }

    @Bean
    public DirectExchange directExchange(){
        return  new DirectExchange("directExchange");
    }

    //需要完全匹配
    @Bean
    public Binding bindingExchange(Queue directQueue, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with("direct");
    }
}
