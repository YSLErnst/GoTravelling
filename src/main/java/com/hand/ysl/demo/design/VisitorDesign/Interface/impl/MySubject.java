package com.hand.ysl.demo.design.VisitorDesign.Interface.impl;

import com.hand.ysl.demo.design.VisitorDesign.Interface.Subject;
import com.hand.ysl.demo.design.VisitorDesign.Interface.Visitor;

/**
 * Created by Ernst on 2017/10/19.
 */
public class MySubject implements Subject{
    @Override
    public void accept(Visitor visitor) {
         visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "ysl'home";
    }
}
