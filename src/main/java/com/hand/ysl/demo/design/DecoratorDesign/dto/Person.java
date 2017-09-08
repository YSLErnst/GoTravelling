package com.hand.ysl.demo.design.DecoratorDesign.dto;

import com.hand.ysl.demo.design.DecoratorDesign.Interface.Human;

/**
 * Created by Ernst on 2017/8/21.
 */
public class Person implements Human{
    @Override
    public void wearClothes() {
        System.out.println("穿什么呢");
    }

    @Override
    public void goWhere() {
        System.out.println("去哪呢");
    }
}
