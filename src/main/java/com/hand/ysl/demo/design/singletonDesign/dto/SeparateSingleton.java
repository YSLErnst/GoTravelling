package com.hand.ysl.demo.design.singletonDesign.dto;

/**
 * Created by Ernst on 2017/8/17.
 * 单例，线程安全
 * 将创建和getInstance分开
 */
public class SeparateSingleton {
    private static SeparateSingleton instance = null;

    /**
     * 私有化构造方法,防止被实例化
     */
    private SeparateSingleton(){
    }

    /**
     * 创建实例方法被synchronized修饰。这样保证了创建实例过程的线程安全
     */
    private static synchronized void syncInit(){
        if(instance==null){
            instance = new SeparateSingleton();
        }
    }

    public static SeparateSingleton getInstance(){
        if(instance==null){
            syncInit();
        }

        return instance;
    }

}
