package com.hand.ysl.demo.design.observerDesign.dto;

import com.hand.ysl.demo.design.observerDesign.Interface.Observer;
import com.hand.ysl.demo.design.observerDesign.Interface.Subject;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Ernst on 2017/9/21.
 */
public abstract class AbstractSubject implements Subject{

    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
       vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            enumeration.nextElement().update();
        }
    }

}
