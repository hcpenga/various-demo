package com.example.variousdemo.rabbitmq;

import com.example.variousdemo.rabbit.many.NeoSender;
import com.example.variousdemo.rabbit.many.NeoSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className: ManyTest
 * @description:
 * @created: 2021/08/24 14:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {

    @Autowired
    private NeoSender neoSender;

    @Autowired
    private NeoSender2 neoSender2;

    @Test
    public void oneToMany(){
        for (int i = 0 ; i < 100 ; i++){
            neoSender.send(i);
        }
    }

    @Test
    public void manyToMany(){
        for(int i = 0 ; i < 100 ; i++){
            neoSender.send(i);
            neoSender2.send(i);
        }
    }
}
