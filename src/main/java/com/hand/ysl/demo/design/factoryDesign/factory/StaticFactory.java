package com.hand.ysl.demo.design.factoryDesign.factory;

import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.Interface.impl.QQSender;
import com.hand.ysl.demo.design.factoryDesign.Interface.impl.SMSSender;

/**
 * Created by Ernst on 2017/8/16.
 * 静态工厂方法模式
 */
public class StaticFactory {
    public static Sender produceSMS(){
        return new SMSSender();
    }

    public static Sender produceQQ(){
        return new QQSender();
    }
}
