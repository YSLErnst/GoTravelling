package com.hand.ysl.demo.design.responsibilityDesign.controller;


import com.hand.ysl.demo.design.responsibilityDesign.dto.MyHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/8/19.
 */
@Controller("ResponsibilityController")
@RequestMapping("/response")
public class ResponsibilityController {

    /*
    浅拷贝
     */
    @RequestMapping(value = "/responsibility", method = RequestMethod.GET)
    public void test() {
        MyHandler handler1 = new MyHandler("h1");
        MyHandler handler2 = new MyHandler("h2");
        MyHandler handler3 = new MyHandler("h3");

        handler1.setHandler(handler2);
        handler2.setHandler(handler3);

        handler1.operator();
    }
}
