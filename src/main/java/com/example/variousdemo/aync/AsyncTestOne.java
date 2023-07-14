package com.example.variousdemo.aync;

/**
 * @author Mark
 * @desc 使用回调函数实现异步demo
 */
public class AsyncTestOne {
    public  interface CallBack {
        void doSuccess(String result);
        void doFailure(String result);
    }
    public static class RegisterAsyncTask{
        public void doAsyncTask(CallBack callBack,String orderCode) {
            //执行异步操作:通知其他系统执行对应的动作...
            new Thread(()->{
                try{
                    //此处使用耗时来模拟异步操作
                    Thread.sleep(2000);
                    //异步方法的执行结果
                    String result = String.format("orderCode【%s】asyncTask success",orderCode);
                    callBack.doSuccess(result);
                }catch (Exception e){
                    String result = String.format("orderCode【%s】asyncTask failure,%s",orderCode,e.getMessage());
                    callBack.doFailure(result);
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        System.out.println("衣物信息入库及异步通知其他系统执行对应的动作");
        System.out.println("开始调用异步任务");
        RegisterAsyncTask asyncTask = new RegisterAsyncTask();
        //异步通知其他系统执行对应的动作
        asyncTask.doAsyncTask(new CallBack() {
            @Override
            public void doSuccess(String result) {
                System.out.printf("异步任务执行结果:%s%n",result);
            }
            @Override
            public void doFailure(String result) {
                System.out.printf("异步任务执行结果:%s%n",result);
            }
        },"8888888");
        System.out.println("衣物信息相关数据入库...");
        System.out.println("主线程继续执行...");
    }
}
