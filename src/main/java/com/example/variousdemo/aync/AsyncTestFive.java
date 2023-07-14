package com.example.variousdemo.aync;

import com.google.common.util.concurrent.*;
import java.util.concurrent.Executors;

/**
 * @author Mark
 * @desc 使用ListenableFuture实现异步demo
 */
public class AsyncTestFive {
    public static void main(String[] args) {
        System.out.println("衣物信息入库及异步通知其他系统执行对应的动作");
        System.out.println("开始调用异步任务");
        String orderCode = "8888888";
        ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
        ListenableFuture<String> future = executor.submit(() -> {
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

        //添加回调
        Futures.addCallback(future, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("异步任务执行结果:"+result);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        }, executor);
        System.out.println("衣物信息相关数据入库...");
        System.out.println("主线程继续执行...");
    }
}
