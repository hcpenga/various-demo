package com.example.variousdemo.aync;

import java.util.concurrent.*;

/**
 * @author Mark
 * @desc 使用java线程池实现异步demo
 */
public class AsyncTestTwo {
    public static void main(String[] args) throws Exception{
        System.out.println("衣物信息入库及异步通知其他系统执行对应的动作");
        System.out.println("开始调用异步任务");
        String orderCode = "8888888";
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //异步通知其他系统执行对应的动作
        Future<String> future = executorService.submit(() -> {
            //执行异步操作:通知其他系统执行对应的动作...
            try {
                //此处使用耗时来模拟异步操作
                Thread.sleep(2000);
                //异步方法的执行结果
                return String.format("orderCode【%s】asyncTask success",orderCode);
            } catch (Exception e) {
                return String.format("orderCode【%s】asyncTask failure,%s",orderCode,e.getMessage());
            }
        });
        System.out.println("衣物信息相关数据入库...");
        System.out.println("主线程继续执行...");
        //异步任务完成后的处理
        String result = future.get();
        System.out.println("异步任务执行结果:"+result);
        //关闭线程池
        executorService.shutdown();
    }
}
