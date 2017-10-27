package com.hand.ysl.demo.design.observerDesign.dto;

/**
 * Created by Ernst on 2017/9/21.
 */
public class MySubject extends AbstractSubject{
    @Override
    public void operation() {
        System.out.println("update self");
        notifyObservers();
    }
}
