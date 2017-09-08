package com.hand.ysl.demo.design.DecoratorDesign.dto;

import com.hand.ysl.demo.design.DecoratorDesign.Interface.Human;

/**
 * Created by Ernst on 2017/8/21.
 * 装饰模式
 * 用了依赖倒置原则
 */
public class DecoratorZero extends Decorator{
    public DecoratorZero(Human human) {
        super(human);
    }

    public void goHome(){
        System.out.println("进房子");
    }

    public void fingMap(){
        System.out.println("找到报纸");
    }

    public void wearClothes(){
        super.wearClothes();
        goHome();
    }

    public void goWhere(){
        super.goWhere();
        goHome();
    }
}
