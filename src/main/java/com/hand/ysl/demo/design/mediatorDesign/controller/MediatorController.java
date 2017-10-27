package com.hand.ysl.demo.design.mediatorDesign.controller;


import com.hand.ysl.demo.design.iteratorDesign.Interface.Collection;
import com.hand.ysl.demo.design.iteratorDesign.Interface.Iterator;
import com.hand.ysl.demo.design.iteratorDesign.Interface.impl.MyCollection;
import com.hand.ysl.demo.design.mediatorDesign.Interface.Mediator;
import com.hand.ysl.demo.design.mediatorDesign.Interface.impl.MyMediator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *中介者模式也是用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，
 * 不利于功能的拓展和维护，因为只要修改一个对象，其它关联的对象都得进行修改。
 * 如果使用中介者模式，只需关心和Mediator类的关系，具体类类之间的关系及调度交给Mediator就行，这有点像spring容器的作用。
 *
 */
@Controller("MediatorController")
@RequestMapping("/mediator")
public class MediatorController {

    /*
    迭代子模式
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }

}
