package com.hand.ysl.demo.design.VisitorDesign.controller;


import com.hand.ysl.demo.design.TemplateDesign.dto.FloatBubleSort;
import com.hand.ysl.demo.design.TemplateDesign.dto.IntBubleSort;
import com.hand.ysl.demo.design.VisitorDesign.Interface.Subject;
import com.hand.ysl.demo.design.VisitorDesign.Interface.Visitor;
import com.hand.ysl.demo.design.VisitorDesign.Interface.impl.MySubject;
import com.hand.ysl.demo.design.VisitorDesign.Interface.impl.MyVisitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/9/13.
 * 访问者模式
 *访问者模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由地演化。
 * 访问者模式适用于数据结构相对稳定算法又易变化的系统。因为访问者模式使得算法操作增加变得容易。
 * 若系统数据结构对象易于变化，经常有新的数据对象增加进来，则不适合使用访问者模式。
 * 访问者模式的优点是增加操作很容易，因为增加操作意味着增加新的访问者。
 * 访问者模式将有关行为集中到一个访问者对象中，其改变不影响系统数据结构。
 * 其缺点就是增加新的数据结构很困难。简单来说，访问者模式就是一种分离对象数据结构与行为的方法，
 * 通过这种分离，可达到为一个被访问者动态添加新的操作而无需做其它的修改的效果。
 */
@Controller("VisitorController")
@RequestMapping("/visitor")
public class VisitorController {

    /*
    浅拷贝
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        Visitor visitor = new MyVisitor();
        Subject subject = new MySubject();
        subject.accept(visitor);
    }

}
