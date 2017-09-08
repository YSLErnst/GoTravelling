package com.hand.ysl.demo.design.adapterDesign.dto;

import com.hand.ysl.demo.design.adapterDesign.Interface.Targetable;

/**
 * Created by Ernst on 2017/8/20.
 */
public class Wrapper implements Targetable{
    private Source source;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method");
    }
}
