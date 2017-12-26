package com.hand.ysl.demo.design.singletonDesign.dto;

/**
 * Created by Ernst on 2017/8/16.
 * 单例，线程不安全
 */
public class SimpleSingleton {
    private static SimpleSingleton instance = null;

    /**
     * 私有化构造方法,防止被实例化
     */
    private SimpleSingleton(){
    }

    /**
     * 静态工程方法，创建实例
     */
    public static SimpleSingleton getInstance(){
        if(instance==null){
            return new SimpleSingleton();
        }else{
            return  instance;
        }
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve(){
        return instance;
    }

    /**
     * 这样每次调用getInstance方法都会给instance对象加锁,实际上只在第一次创建的时候需要线程同步,因此这样做会性能较差
     */
/*    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    } */

    /**
     *这样似乎解决了上面方法每次都加锁的问题。但是还是会有会问。
     * java指令中创建对象和赋值是分开进行的。也就是说instance = new Singleton是分俩步进行的
     * 但是JVM并不保证它们的执行顺序，也就是说JVM可能会在new Singleton后为新的Singleton实例分配空间然后直接赋值给
     * instance成员，后面再去初始化这个Singleton实例。这样当A线程在第二个if里为新的Singleton实例分配空间并赋值给instance后，
     * B线程进入第二个if判断，判断instance不为null直接返回了instance，这样就出错了，因为此时Singleton实例没有初始化
     *
     */
/*    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }*/
}
