package com.hand.ysl.demo.design.factoryDesign.factory;

import com.hand.ysl.demo.design.factoryDesign.Interface.Provider;
import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.Interface.impl.QQSender;
import com.hand.ysl.demo.design.factoryDesign.Interface.impl.SMSSender;

/**
 * Created by Ernst on 2017/8/16.
 * 抽象工厂方法模式
 */
public class AbstractSendQQFactory implements Provider{
    @Override
    public Sender produce() {
        return new QQSender();
    }
}
