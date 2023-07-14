//package com.example.variousdemo.thread;
//
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.TimeUnit;
//
//public class Task3 implements Callable<String> {
//
//
//    @Override
//    public String call(){
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(getClass().getSimpleName()+"执行完成");
//        return getClass().getSimpleName();
//    }
//}
