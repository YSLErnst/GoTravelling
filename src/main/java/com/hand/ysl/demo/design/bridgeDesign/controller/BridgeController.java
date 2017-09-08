package com.hand.ysl.demo.design.bridgeDesign.controller;

import com.hand.ysl.demo.design.bridgeDesign.Interface.SourceAbles;
import com.hand.ysl.demo.design.bridgeDesign.dto.Bridge;
import com.hand.ysl.demo.design.bridgeDesign.dto.SourceBridge;
import com.hand.ysl.demo.design.bridgeDesign.dto.SourceSub1;
import com.hand.ysl.demo.design.bridgeDesign.dto.SourceSub2;
import com.hand.ysl.demo.design.builderDesign.Interface.PersonBuilder;
import com.hand.ysl.demo.design.builderDesign.Interface.impl.ManBuilder;
import com.hand.ysl.demo.design.builderDesign.director.PersonDirector;
import com.hand.ysl.demo.design.builderDesign.dto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/8/25.
 * 桥接模式
 *
 */
@Controller("BridgeController")
@RequestMapping("/bridge")
public class BridgeController {

        @RequestMapping(value = "/bridge", method = RequestMethod.GET)
        public void buildMan() {
            SourceAbles sourceAbles1 = new SourceSub1();
            SourceAbles sourceAbles2 = new SourceSub2();
            Bridge bridge = new SourceBridge();
            bridge.setSourceAbles(sourceAbles1);
            bridge.method();
            bridge.setSourceAbles(sourceAbles2);
            bridge.method();
        }

}
