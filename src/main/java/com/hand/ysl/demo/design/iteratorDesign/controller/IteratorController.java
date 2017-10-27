package com.hand.ysl.demo.design.iteratorDesign.controller;


import com.hand.ysl.demo.design.TemplateDesign.dto.FloatBubleSort;
import com.hand.ysl.demo.design.TemplateDesign.dto.IntBubleSort;
import com.hand.ysl.demo.design.iteratorDesign.Interface.Collection;
import com.hand.ysl.demo.design.iteratorDesign.Interface.Iterator;
import com.hand.ysl.demo.design.iteratorDesign.Interface.impl.MyCollection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 *
 */
@Controller("IteratorController")
@RequestMapping("/iterator")
public class IteratorController {

    /*
    迭代子模式
     */
    @RequestMapping(value = "/iterator", method = RequestMethod.GET)
    public void strategyTest() {
        Collection collection = new MyCollection();
        Iterator iter = collection.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

}
