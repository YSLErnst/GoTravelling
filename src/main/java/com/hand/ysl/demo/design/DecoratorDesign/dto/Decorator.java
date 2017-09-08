package com.hand.ysl.demo.design.DecoratorDesign.dto;

import com.hand.ysl.demo.design.DecoratorDesign.Interface.Human;

/**
 * Created by Ernst on 2017/8/21.
 */
public abstract class Decorator implements Human{
    private Human human;

    public Decorator(Human human) {
        this.human = human;
    }

    public void wearClothes(){
        human.wearClothes();
    }

    public void goWhere(){
        human.goWhere();
    }
}
