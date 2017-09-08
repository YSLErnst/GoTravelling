package com.hand.ysl.demo.design.facadeDesign.controller;
import com.hand.ysl.demo.design.facadeDesign.dto.Computer;
import com.hand.ysl.demo.design.factoryDesign.Interface.Provider;
import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.factory.AbstractSendQQFactory;
import com.hand.ysl.demo.design.factoryDesign.factory.AbstractSendSMSFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 * 外观模式
 * 通过统一的外观类来实现客户端和子系统之间松耦合，调用者不需要知道子系统的内部结构，只需要跟Facade类交互即可。
 *
 */
@Controller("FacadeController")
@RequestMapping("/facade")
public class FacadeController {

	@RequestMapping(value = "/facade", method = RequestMethod.GET)
	public void facade() {
		Computer computer = new Computer();
		computer.start();
		System.out.println("running--------------");
		computer.disconnect();
	}
}
