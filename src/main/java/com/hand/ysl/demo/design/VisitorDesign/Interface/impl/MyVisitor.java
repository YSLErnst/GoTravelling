package com.hand.ysl.demo.design.VisitorDesign.Interface.impl;

import com.hand.ysl.demo.design.VisitorDesign.Interface.Subject;
import com.hand.ysl.demo.design.VisitorDesign.Interface.Visitor;

/**
 * Created by Ernst on 2017/10/19.
 */
public class MyVisitor implements Visitor{
    @Override
    public void visit(Subject subject) {
        System.out.println("visit the subject:"+subject.getSubject());
    }
}
