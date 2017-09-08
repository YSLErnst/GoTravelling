package com.hand.ysl.demo.design.DecoratorDesign.controller;
import com.hand.ysl.demo.design.DecoratorDesign.Interface.Human;
import com.hand.ysl.demo.design.DecoratorDesign.dto.Decorator;
import com.hand.ysl.demo.design.DecoratorDesign.dto.DecoratorZero;
import com.hand.ysl.demo.design.DecoratorDesign.dto.Person;
import com.hand.ysl.demo.design.factoryDesign.Interface.Provider;
import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.factory.AbstractSendQQFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller("DecoratorController")
@RequestMapping("/decorator")
public class DecoratorController {

	@RequestMapping(value = "/dec", method = RequestMethod.GET)
	public void dec() {
		Human human = new Person();
		Decorator decorator = new DecoratorZero(human);
		decorator.wearClothes();
		decorator.goWhere();
	}

}
