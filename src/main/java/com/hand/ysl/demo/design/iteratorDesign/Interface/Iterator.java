package com.hand.ysl.demo.design.iteratorDesign.Interface;

/**
 * Created by Ernst on 2017/10/8.
 */
public interface Iterator {
    //前移
    public Object previous();

    //后移
    public Object next();

    //是否有下一个
    public boolean hasNext();

    //取得第一个
    public Object first();
}
