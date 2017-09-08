package com.hand.ysl.demo.design.prototypeDesign.controller;


import com.hand.ysl.demo.design.prototypeDesign.dto.NewDeepPrototype;
import com.hand.ysl.demo.design.prototypeDesign.dto.NewPrototype;
import com.hand.ysl.demo.design.prototypeDesign.dto.Prototype;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/8/19.
 */
@Controller("PrototypeController")
@RequestMapping("/prototype")
public class PrototypeController {

    /*
    浅拷贝
     */
    @RequestMapping(value = "/testShallowPrototype", method = RequestMethod.GET)
    public void testShallowPrototype() {
        Prototype prototype = new Prototype();
        prototype.setName("original name");
        NewPrototype newPrototype = new NewPrototype();
        newPrototype.setId("original id");
        newPrototype.setPrototype(prototype);

        NewPrototype copyObj = (NewPrototype)newPrototype.clone();
        copyObj.setId("copy id");
        copyObj.getPrototype().setName("copy name");

        System.out.println("original object id:"+newPrototype.getId());
        System.out.println("original object name:"+newPrototype.getPrototype().getName());
        System.out.println("copy object id:"+copyObj.getId());
        System.out.println("copy object name:"+copyObj.getPrototype().getName());
        /*
        结果:
        original object id:original id
        original object name:copy name
        copy object id:copy id
        copy object name:copy name
         */
        //原因：浅拷贝中基本数据类型的变量重新创建，引用型变量还是引用以前原型的
    }

      /*
       深拷贝
       */
    @RequestMapping(value = "/testDeepPrototype", method = RequestMethod.GET)
    public void testDeepPrototype() {
        Prototype po = new Prototype();
        po.setName("original object name");
        NewDeepPrototype se = new NewDeepPrototype();
        se.setPrototype(po);

        NewDeepPrototype deepClone = (NewDeepPrototype)se.deepClone();
        deepClone.getPrototype().setName("copy object name");

        System.out.println("original name:" + se.getPrototype().getName());
        System.out.println("cloned name:" + deepClone.getPrototype().getName());
        /*
        结果
        original name:original object name
        cloned name:copy object name
         */
        //原因：深拷贝不仅实现了基本数据类型的拷贝，还实现了引用类型的拷贝
    }
}
