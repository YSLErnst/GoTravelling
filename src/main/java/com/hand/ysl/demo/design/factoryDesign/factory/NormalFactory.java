package com.hand.ysl.demo.design.factoryDesign.factory;

import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.Interface.impl.QQSender;
import com.hand.ysl.demo.design.factoryDesign.Interface.impl.SMSSender;

/**
 * Created by Ernst on 2017/8/16.
 * 普通工厂模式
 */
public class NormalFactory {
    public Sender produce(String type){
        if("sms".equals(type)){
            return new SMSSender();
        }else if("qq".equals(type)){
            return new QQSender();
        }else{
            System.out.println("请输入正确的类型");
            return null;
        }
    }
}
