package com.hand.ysl.dynamictest;

import com.hand.ysl.dynamic.Interface.Hello;
import com.hand.ysl.dynamic.Interface.impl.HelloImpl;
import com.hand.ysl.dynamic.proxy.CGLibProxy;
import com.hand.ysl.dynamic.proxy.DynamicProxy;


/**
 * Created by Ernst on 2018/1/25.
 */
public class TestCGLibProxy {
    public static void main(String[] args) {
        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("mmm");
    }
}
