package com.hand.ysl.demo.design.factoryDesign.controllers;
import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.factory.ManyFactory;
import com.hand.ysl.demo.design.factoryDesign.factory.NormalFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 * 多个工厂方法模式
 * 是对普通工厂方法模式的改进，在普通工厂方法模式中，
 * 如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
@Controller("ManyFactoryController")
@RequestMapping("/manyFactory")
public class ManyFactoryController {

	@RequestMapping(value = "/qq", method = RequestMethod.GET)
	public void sendQQ() {
		ManyFactory factory = new ManyFactory();
		Sender qqSender = factory.produceQQ();
		qqSender.send();
	}

	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public void sendSMS() {
		ManyFactory factory = new ManyFactory();
		Sender smsSender = factory.produceSMS();
		smsSender.send();
	}
}
