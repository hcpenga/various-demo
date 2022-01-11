package com.example.variousdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.example.variousdemo.annotation.hcLog)")
    public void testLog(){

    }

    @Around("testLog()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] parameters = joinPoint.getArgs();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName() + "#" + joinPoint.getSignature().getName();
        Object resObj = joinPoint.proceed(parameters);
        System.out.println(className);
        return resObj;
    }

}
