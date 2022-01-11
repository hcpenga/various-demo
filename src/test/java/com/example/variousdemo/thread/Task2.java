package com.example.variousdemo.thread;

import java.util.concurrent.TimeUnit;

public class Task2 extends Thread{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getClass().getSimpleName()+"执行完成");
    }
}
