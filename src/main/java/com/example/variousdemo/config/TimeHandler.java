package com.example.variousdemo.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @className: TimeHandler
 * @description:
 * @created: 2021/09/03 10:54
 */
@Aspect
@Component
public class TimeHandler {

    @Pointcut("execution(* com.example.variousdemo.controller.*.*(..))")
    public void poincut(){

    }

    @Before("poincut()")
    public void printBeforeTime(){
        System.out.println("before time :" + System.currentTimeMillis());
    }

    @After("poincut()")
    public void printAfterTime(){
        System.out.println("after time :" + System.currentTimeMillis());
    }
}
