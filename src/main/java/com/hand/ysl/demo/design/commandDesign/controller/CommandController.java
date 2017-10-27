package com.hand.ysl.demo.design.commandDesign.controller;

import com.hand.ysl.demo.design.commandDesign.Interface.Command;
import com.hand.ysl.demo.design.commandDesign.Interface.impl.MyCommand;
import com.hand.ysl.demo.design.commandDesign.dto.Invoker;
import com.hand.ysl.demo.design.commandDesign.dto.Receiver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/8/25.
 * 桥接模式
 *
 */
@Controller("CommandController")
@RequestMapping("/command")
public class CommandController {

        @RequestMapping(value = "/test", method = RequestMethod.GET)
        public void test() {
            Receiver receiver = new Receiver();
            Command command = new MyCommand(receiver);
            Invoker invoker = new Invoker(command);
            invoker.invoke();
        }

}
