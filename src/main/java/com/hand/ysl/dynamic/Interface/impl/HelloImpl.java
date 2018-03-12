package com.hand.ysl.dynamic.Interface.impl;

import com.hand.ysl.dynamic.Interface.Hello;

/**
 * Created by Ernst on 2018/1/25.
 */
public class HelloImpl implements Hello{
    @Override
    public void say(String name) {
        System.out.println("Hello,"+name);
    }
}
