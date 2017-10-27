package com.hand.ysl.demo.design.iteratorDesign.Interface.impl;

import com.hand.ysl.demo.design.iteratorDesign.Interface.Collection;
import com.hand.ysl.demo.design.iteratorDesign.Interface.Iterator;


/**
 * Created by Ernst on 2017/10/8.
 */
public class MyCollection implements Collection{
    public String string[] = {"A","B","C","D","E"};
    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return string[i];
    }

    @Override
    public int size() {
        return string.length;
    }
}
