package com.hand.ysl.demo.design.prototypeDesign.dto;

/**
 * Created by Ernst on 2017/8/19.
 */
public class NewPrototype implements Cloneable{
    private String id;

    private Prototype prototype;

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }
}
