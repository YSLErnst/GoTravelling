package com.hand.ysl.demo.design.observerDesign.dto;

import com.hand.ysl.demo.design.observerDesign.Interface.Observer;

/**
 * Created by Ernst on 2017/9/18.
 */
public class Observer1 implements Observer{

    @Override
    public void update() {
        System.out.println("observer1 has received");
    }
}
