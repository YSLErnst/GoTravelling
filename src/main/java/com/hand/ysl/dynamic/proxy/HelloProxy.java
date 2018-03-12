package com.hand.ysl.dynamic.proxy;

import com.hand.ysl.dynamic.Interface.Hello;

/**
 * Created by Ernst on 2018/1/25.
 */
public class HelloProxy implements Hello{
    private Hello hello;

    public HelloProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before(){
        System.out.println("excute before-----");
    }

    private void after(){
        System.out.println("excute after-------");
    }
}
