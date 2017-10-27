package com.hand.ysl.demo.design.strategyDesign.controller;


import com.hand.ysl.demo.design.prototypeDesign.dto.NewDeepPrototype;
import com.hand.ysl.demo.design.prototypeDesign.dto.NewPrototype;
import com.hand.ysl.demo.design.prototypeDesign.dto.Prototype;
import com.hand.ysl.demo.design.strategyDesign.Interface.ICaculator;
import com.hand.ysl.demo.design.strategyDesign.dto.Plus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/8/19.
 * 策略模式
 *
 * 略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户。
 * 需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类（可有可无，属于辅助类）
 */
@Controller("StrategyController")
@RequestMapping("/strategy")
public class StrategyController {

    @RequestMapping(value = "/strategyTest", method = RequestMethod.GET)
    public void strategyTest() {
        ICaculator caculator = new Plus();
        int result = caculator.caculate("1*6");
        System.out.println(result);
    }

}
