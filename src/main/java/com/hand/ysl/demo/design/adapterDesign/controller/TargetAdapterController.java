package com.hand.ysl.demo.design.adapterDesign.controller;

import com.hand.ysl.demo.design.adapterDesign.Interface.SourceAble;
import com.hand.ysl.demo.design.adapterDesign.Interface.Targetable;
import com.hand.ysl.demo.design.adapterDesign.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 适配器模式
 */
@Controller("TargetAdapterController")
@RequestMapping("/target")
public class TargetAdapterController {

    /**
     * 类的适配器模式
     * 核心思想就是：有一个Source类，拥有一个方法，待适配，
     * 目标接口是Targetable，通过Adapter类，将Source的功能扩展到Targetable里
     * <p>
     * 应用场景：
     * 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
     */
    @RequestMapping(value = "/classTargetAdapter", method = RequestMethod.GET)
    public void classTargetAdapter() {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }

    /**
     * 对象的适配器模式
     * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，
     * 而是持有Source类的实例，以达到解决兼容性的问题
     *
     * 使用场景
     * 当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，
     * 持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
     */
    @RequestMapping(value = "/objectTargetAdapter", method = RequestMethod.GET)
    public void objectTargetAdapter() {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }


    /**
     * 接口的适配器模式
     * 当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可
     */
    @RequestMapping(value = "/interfaceTargetAdapter", method = RequestMethod.GET)
    public void interfaceTargetAdapter() {
        SourceAble sourceSub1 = new SourceSub1();
        sourceSub1.method1();
        sourceSub1.method2();

        SourceAble sourceSub2 = new SourceSub2();
        sourceSub2.method1();
        sourceSub2.method2();
    }
}