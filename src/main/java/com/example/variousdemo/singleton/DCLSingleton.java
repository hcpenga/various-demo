package com.example.variousdemo.singleton;

import lombok.Synchronized;

/**
 * @className: DCLSingleton
 * @description: DCL（Double Check Lock）加锁的单例模式
 * @created: 2021/08/30 14:05
 */
public class DCLSingleton {
    private static DCLSingleton singleton = null;

    private DCLSingleton(){
    }

    public static DCLSingleton getInstance(){
        if(singleton == null){
            synchronized (DCLSingleton.class){
                if(singleton == null){
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
