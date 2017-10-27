package com.hand.ysl.demo.design.stateDesign.dto;

/**
 * Created by Ernst on 2017/10/18.
 */
public class State {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println("do method 1");
    }

    public void method2(){
        System.out.println("do method 2");
    }
}
