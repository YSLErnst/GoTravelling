package com.hand.ysl.demo.design.iteratorDesign.Interface;

import java.util.Iterator;

/**
 * Created by Ernst on 2017/10/8.
 */
public interface Collection {
    public com.hand.ysl.demo.design.iteratorDesign.Interface.Iterator iterator();

    public Object get(int i);

    public int size();
}
