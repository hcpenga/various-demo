package com.example.variousdemo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @className: FirstThread
 * @description:
 * @created: 2021/08/26 11:13
 */
public class FirstThread {
    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition CA = lock.newCondition();
    private static final Condition CB = lock.newCondition();
    private static final Condition CC = lock.newCondition();

    private static final CountDownLatch latchB = new CountDownLatch(1);
    private static final CountDownLatch latchC = new CountDownLatch(1);


    public static void main(String[] args) {
        Thread threadA = new Thread(() ->{
            lock.lock();

            try{
                for(int i = 0 ; i < 10 ; i++){
                    System.out.print("A");
                    CB.signal();
                    if(i == 0){
                        latchB.countDown();
                    }
                    CA.await();
                }

                CB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() ->{
            //设定门栏,以免被先执行
            try{
                latchB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            try {
                for (int i = 0 ; i < 10 ; i++) {
                    System.out.print("B");
                    CC.signal();
                    if(i == 0){
                        latchC.countDown();
                    }
                    CB.await();
                }
                CC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadC = new Thread(() ->{
            //设立门栏,以免被先执行
            try{
                latchC.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try{
                for(int i = 0 ; i < 10 ; i++){
                    System.out.print("C");
                    CA.signal();
                    CC.await();
                }

                CA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });


        threadA.start();
        threadB.start();
        threadC.start();
    }

}
