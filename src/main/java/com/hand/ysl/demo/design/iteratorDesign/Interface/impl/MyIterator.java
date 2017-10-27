package com.hand.ysl.demo.design.iteratorDesign.Interface.impl;

import com.hand.ysl.demo.design.iteratorDesign.Interface.Collection;
import com.hand.ysl.demo.design.iteratorDesign.Interface.Iterator;

/**
 * Created by Ernst on 2017/10/8.
 */
public class MyIterator implements Iterator{

    private Collection collection;

    private int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if(pos>0){
            pos--;
        }
        return collection.get(pos);
    }

    @Override
    public Object next() {
        if(pos<collection.size()-1){
            pos++;
        }
        return collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if(pos<collection.size()-1){
            return true;
        }
        return false;
    }

    @Override
    public Object first() {
        pos = 0;
        return collection.get(pos);
    }
}
