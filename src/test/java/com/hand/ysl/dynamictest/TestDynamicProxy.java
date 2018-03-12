package com.hand.ysl.dynamictest;

import com.hand.ysl.dynamic.Interface.Hello;
import com.hand.ysl.dynamic.Interface.impl.HelloImpl;
import com.hand.ysl.dynamic.proxy.DynamicProxy;


/**
 * Created by Ernst on 2018/1/25.
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();

        DynamicProxy dynamicProxy = new DynamicProxy(hello);

/*        Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                dynamicProxy);*/

        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say("jack");
    }
}
