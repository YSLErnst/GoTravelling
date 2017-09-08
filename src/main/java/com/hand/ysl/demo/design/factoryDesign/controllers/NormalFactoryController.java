package com.hand.ysl.demo.design.factoryDesign.controllers;
import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.factory.NormalFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 * 普通工厂模式
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 */
@Controller("NormalFactoryController")
@RequestMapping("/normalFactory")
public class NormalFactoryController {

	@RequestMapping(value = "/qq", method = RequestMethod.GET)
	public void sendQQ() {
		NormalFactory factory = new NormalFactory();
		Sender qqSender = factory.produce("qq");
		qqSender.send();
	}

	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public void sendSMS() {
		NormalFactory factory = new NormalFactory();
		Sender smsSender = factory.produce("sms");
		smsSender.send();
	}
}
