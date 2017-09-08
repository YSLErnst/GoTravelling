package com.hand.ysl.demo.design.factoryDesign.Interface.impl;

import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;

/**
 * Created by Ernst on 2017/8/16.
 */
public class QQSender implements Sender{
    @Override
    public void send() {
        System.out.println("send:QQ");
    }
}
