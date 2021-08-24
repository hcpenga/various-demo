package com.example.variousdemo.rabbitmq;

import com.example.variousdemo.rabbit.direct.DirectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className: DirectTest
 * @description:
 * @created: 2021/08/24 10:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectTest {

    @Autowired
    private DirectSender directSender;

    @Test
    public void directSender(){
        directSender.send();
    }
}
