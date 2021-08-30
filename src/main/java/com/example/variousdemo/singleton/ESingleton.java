package com.example.variousdemo.singleton;

/**
 * @className: ESingleton
 * @description: 饿汉式单例
 * @created: 2021/08/30 14:02
 */
public class ESingleton {
    private static ESingleton singleton = new ESingleton();
    private ESingleton(){

    }

    public static ESingleton getInstance(){
        return singleton;
    }

}
