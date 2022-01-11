package com.example.variousdemo.thread;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

public class Multithread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //测试1
//        Thread thread1 = new Thread(new Task1());
//        thread1.start();
//
//        Thread thread2 = new Thread(new Task2());
//        thread2.start();
//
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //测试2
        ExecutorService executorService = Executors.newCachedThreadPool();

//        executorService.execute(new Task1());

        Future<String> submit = executorService.submit(new Task3());

        if(StringUtils.equals(submit.get(),"Task3")){
            executorService.execute(new Task1());
        }


        executorService.awaitTermination(5,TimeUnit.SECONDS);
    }
}
