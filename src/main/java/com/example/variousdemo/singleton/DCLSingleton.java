package com.example.variousdemo.singleton;

import lombok.Synchronized;

import java.util.HashMap;
import java.util.Map;

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


    public static void main(String[] args) {
        Map map = new HashMap<>();
        int target = 9;
        int a[] = {1,2,3,4,5,6,7,8,9};
        for(int i = 0 ; i <  a.length ; i++){
            if(map.containsKey(9-a[i])){
                System.out.println("数组下标为" + i + ","+map.get(9-a[i]));
            } else {
                map.put(a[i],i);
            }
        }
    }
}
