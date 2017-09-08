package com.hand.ysl.demo.design.factoryDesign.controllers;
import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.factory.ManyFactory;
import com.hand.ysl.demo.design.factoryDesign.factory.StaticFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 * 多个工厂方法模式
 * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 */
@Controller("StaticFactoryController")
@RequestMapping("/staticFactory")
public class StaticFactoryController {

	@RequestMapping(value = "/qq", method = RequestMethod.GET)
	public void sendQQ() {
		Sender qqSender = StaticFactory.produceQQ();
		qqSender.send();
	}

	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public void sendSMS() {
		Sender smsSender = StaticFactory.produceSMS();
		smsSender.send();
	}
}
