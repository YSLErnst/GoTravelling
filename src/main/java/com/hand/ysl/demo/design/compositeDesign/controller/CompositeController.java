package com.hand.ysl.demo.design.compositeDesign.controller;

import com.hand.ysl.demo.design.compositeDesign.dto.Cabinet;
import com.hand.ysl.demo.design.compositeDesign.dto.Chassis;
import com.hand.ysl.demo.design.compositeDesign.dto.Disk;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/8/18.
 * 组合模式
 */
@Controller("CompositeController")
@RequestMapping("/composite")
public class CompositeController {

        @RequestMapping(value = "/composite", method = RequestMethod.GET)
        public void composite() {
            Cabinet cabinet = new Cabinet("柜子");
            Chassis chassis = new Chassis("盒子");
            cabinet.add(chassis);
            chassis.add(new Disk("硬盘"));
            System.out.println("整个柜子的原始价格"+cabinet.originPrice());
            System.out.println("整个柜子的折扣价格"+cabinet.discountPrice());
        }
}
