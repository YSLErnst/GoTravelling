package com.hand.ysl.demo.design.mementoDesign.dto;

/**
 * Created by Ernst on 2017/10/17.
 */
public class Memento {
    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
