package com.hand.ysl.dynamictest;

import com.hand.ysl.dynamic.Interface.Hello;
import com.hand.ysl.dynamic.Interface.impl.HelloImpl;
import com.hand.ysl.dynamic.proxy.HelloProxy;

/**
 * Created by Ernst on 2018/1/25.
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        Hello hello = new HelloProxy(new HelloImpl());
        hello.say("jack");
    }
}
