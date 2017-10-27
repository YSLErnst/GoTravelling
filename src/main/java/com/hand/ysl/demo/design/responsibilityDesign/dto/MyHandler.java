package com.hand.ysl.demo.design.responsibilityDesign.dto;

import com.hand.ysl.demo.design.responsibilityDesign.Interface.Handler;

/**
 * Created by Ernst on 2017/10/9.
 */
public class MyHandler extends AbstractHandler implements Handler {
    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name+" deal");
        if (getHandler()!=null){
            getHandler().operator();
        }
    }
}
