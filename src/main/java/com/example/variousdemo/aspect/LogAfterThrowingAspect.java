package com.example.variousdemo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAfterThrowingAspect {

    private final static Logger log = Logger.getLogger(LogAfterThrowingAspect.class);
    @AfterThrowing(value = "bean(*Controller)",throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        String classMethod = joinPoint.getSignature().getDeclaringType().getSimpleName() + "#" + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.error("Aspect Exception: classMethod:"+classMethod +",args:"+args);
    }
}
