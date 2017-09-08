package com.hand.ysl.demo.design.singletonDesign.dto;

/**
 * Created by Ernst on 2017/8/17.
 * 单例，线程安全
 */
public class StaticFactorySingleton {

    /**
     * 私有化构造方法,防止被实例化
     */
    private StaticFactorySingleton(){
    }

    /**
     * 使用内部类来维护单例
     */
    private static class SingletonFactory{
        private static StaticFactorySingleton instance = new StaticFactorySingleton();
    }

    /**
     * JVM内部的机制保证了类被加载时这个类的加载过程是线程互斥的
     * 这样当我们第一次调用getInstance的时候，JVM能够保证instance只被创建一次，
     * 并且保证把赋值给instance的内存给初始化完毕。既解决了线程安全问题又解决了性能问题
     * @return
     */
    public static StaticFactorySingleton getInstance(){
        return SingletonFactory.instance;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve(){
        return getInstance();
    }


}
