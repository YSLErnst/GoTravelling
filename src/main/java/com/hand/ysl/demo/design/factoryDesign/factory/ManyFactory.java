package com.hand.ysl.demo.design.factoryDesign.factory;

import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.Interface.impl.QQSender;
import com.hand.ysl.demo.design.factoryDesign.Interface.impl.SMSSender;

/**
 * Created by Ernst on 2017/8/16.
 * 多个工厂方法模式
 */
public class ManyFactory {
    public Sender produceSMS(){
        return new SMSSender();
    }

    public Sender produceQQ(){
        return new QQSender();
    }
}
