package com.hand.ysl.demo.design.proxyDesign.controller;
import com.hand.ysl.demo.design.factoryDesign.Interface.Provider;
import com.hand.ysl.demo.design.factoryDesign.Interface.Sender;
import com.hand.ysl.demo.design.factoryDesign.factory.AbstractSendQQFactory;
import com.hand.ysl.demo.design.factoryDesign.factory.AbstractSendSMSFactory;
import com.hand.ysl.demo.design.proxyDesign.Interface.BuyCar;
import com.hand.ysl.demo.design.proxyDesign.dto.People;
import com.hand.ysl.demo.design.proxyDesign.dto.ProxyClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 * 代理模式
 * 代理模式主要使用了java的多态，干活的是被代理类，代理类主要是接活，你让我干活，好，我交给幕后的类去干，你满意就成
 * 怎么知道被代理类能不能干呢？同根就成，大家知根知底，你能做啥，我能做啥都清楚得很，同样一个接口。
 *
 * 抽象角色：声明真实对象和代理对象的共同接口。
　　代理角色：代理对象角色内部含有对真实对象的引用，从而可以操作真实对象，同时代理对象提供与真实对象相同的接口以便在任何时刻都能代替真实对象。同时，代理对象　　　　　　　　可以在执行真实对象操作时，附加其他的操作，相当于对真实对象进行封装。
　　真实角色：代理角色所代表的真实对象，是我们最终要引用的对象。
 */
@Controller("ProxyController")
@RequestMapping("/Proxy")
public class ProxyController {

	@RequestMapping(value = "/proxy", method = RequestMethod.GET)
	public void proxy() {
		People people = new People();
		people.setName("zs");
		people.setCash(60000);
		people.setVip("vip");
		ProxyClass buy = new ProxyClass();
		buy.setPerple(people);
		buy.buyCar();
	}
}
