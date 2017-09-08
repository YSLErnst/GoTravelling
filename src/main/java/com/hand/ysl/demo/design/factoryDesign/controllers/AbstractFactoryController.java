package com.hand.ysl.demo.design.factoryDesign.controllers;
import com.hand.ysl.demo.design.factoryDesign.Interface.Provider;
import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.factory.AbstractSendQQFactory;
import com.hand.ysl.demo.design.factoryDesign.factory.AbstractSendSMSFactory;
import com.hand.ysl.demo.design.factoryDesign.factory.StaticFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 * 抽象工厂方法模式
 * 其实这个模式的好处就是，如果你现在想增加一个功能：发及时信息，则只需做一个实现类，实现Sender接口，
 * 同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
 */
@Controller("AbstractFactoryController")
@RequestMapping("/abstractFactory")
public class AbstractFactoryController {

	@RequestMapping(value = "/qq", method = RequestMethod.GET)
	public void sendQQ() {
		Provider provider = new AbstractSendQQFactory();
		Sender qqSender = provider.produce();
		qqSender.send();
	}

	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public void sendSMS() {
		Provider provider = new AbstractSendSMSFactory();
		Sender smsSender = provider.produce();
		smsSender.send();
	}
}
