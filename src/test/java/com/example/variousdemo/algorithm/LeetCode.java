package com.example.variousdemo.algorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetCode {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     */
    @Test
    public void palindrome(){
        String demo = "babad";
        char[] chars = demo.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            for(int j = i+1; j < chars.length; j++){
                if(chars[i] == chars[j]){

                }
            }
        }
    }
}
