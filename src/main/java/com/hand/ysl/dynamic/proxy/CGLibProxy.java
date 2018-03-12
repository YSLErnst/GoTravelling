package com.hand.ysl.dynamic.proxy;

import clojure.lang.Obj;
import org.springframework.cglib.core.ClassEmitter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Ernst on 2018/1/26.
 */
public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy(){
    }

    public static CGLibProxy getInstance(){
        return instance;
    }

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(object,args);
        after();
        return result;
    }

    private void before(){
        System.out.println("excute before-----");
    }

    private void after(){
        System.out.println("excute after-------");
    }
}
