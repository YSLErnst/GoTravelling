package com.hand.ysl.demo.design.compositeDesign.dto;

import java.util.Iterator;

/**
 * Created by Ernst on 2017/9/7.
 */
public abstract class Equipment {
    private String name;

    public Equipment(String name){
        this.name = name;
    }

    // 实体价格
    public abstract double originPrice();

    // 折扣价格
    public abstract double discountPrice();

    // 增加部件的方法
    public boolean add(Equipment equipment){
        return true;
    }

    // 移除部件方法
    public boolean remove(Equipment equipment){
        return true;
    }

    // 组合体内访问各个部件的方法.
    public Iterator iter(){
        return null;
    }
}
