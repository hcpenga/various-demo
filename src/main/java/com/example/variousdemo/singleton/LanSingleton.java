package com.example.variousdemo.singleton;

/**
 * @className: BaoSingleton
 * @description: 懒汉式单例
 * @created: 2021/08/30 13:57
 */
public class LanSingleton {

    private  static LanSingleton singleton = null;

    private LanSingleton(){

    }

    public static LanSingleton getInstance(){
        if(singleton == null){
            singleton = new LanSingleton();
        }
        return singleton;
    }
}
