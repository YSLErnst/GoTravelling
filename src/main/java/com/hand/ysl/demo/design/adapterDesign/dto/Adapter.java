package com.hand.ysl.demo.design.adapterDesign.dto;

import com.hand.ysl.demo.design.adapterDesign.Interface.Targetable;

/**
 * Created by Ernst on 2017/8/20.
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
