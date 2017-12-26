package com.hand.ysl.demo.design.prototypeDesign.dto;

import java.io.*;

/**
 * Created by Ernst on 2017/8/19.
 */
public class NewDeepPrototype implements Serializable{
    private String name;

    private Prototype prototype;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }

    /**
     * 用流来实现对象的深拷贝
     * @return
     */
    public Object deepClone(){
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return oi.readObject();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
