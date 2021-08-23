package com.example.variousdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @className: RedisController
 * @description:
 * @created: 2021/08/20 11:16
 */
@RestController
@RequestMapping("/redisController")
public class RedisController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private static  int num = 100;
    @GetMapping("/testSet")
    public void testSet(){
        stringRedisTemplate.opsForValue().set("leave","HC");
        System.out.println("执行完毕");
    }


    @GetMapping("/testReduce")
    public String testReduce(){
        String key = "bvn";
        String uuid = UUID.randomUUID().toString();
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key,uuid,30, TimeUnit.SECONDS);
        if(!flag){
            return "no way";
        }
        try{
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if(stock > 0){
                int realStock = stock -1;
                stringRedisTemplate.opsForValue().set("stock",realStock+"");
                System.out.println("库存："+realStock);
            } else {
                System.out.println("库存不足");
            }
        }finally {
            if(uuid.equals(stringRedisTemplate.opsForValue().get(key))){
                stringRedisTemplate.delete(key);
            }
        }
        return "finish";
    }
}
