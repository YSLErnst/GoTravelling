package com.hand.ysl.demo.design.VisitorDesign.Interface;

/**
 * Created by Ernst on 2017/10/19.
 */
public interface Subject {
    public void accept(Visitor visitor);

    public String getSubject();
}
