package com.example.variousdemo.rabbitmq;

import com.example.variousdemo.rabbit.fanout.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className: FanoutTest
 * @description:
 * @created: 2021/08/23 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {

    @Autowired
    private FanoutSender sender;

    @Test
    public void fanoutSender(){
        sender.send();
    }
}
