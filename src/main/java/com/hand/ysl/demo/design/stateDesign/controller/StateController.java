package com.hand.ysl.demo.design.stateDesign.controller;
import com.hand.ysl.demo.design.proxyDesign.dto.People;
import com.hand.ysl.demo.design.proxyDesign.dto.ProxyClass;
import com.hand.ysl.demo.design.stateDesign.dto.Context;
import com.hand.ysl.demo.design.stateDesign.dto.State;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 *
 * 状态模式
 */
@Controller("StateController")
@RequestMapping("/state")
public class StateController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		State state = new State();
		Context context = new Context(state);
		//设置第一种状态
		state.setValue("method1");
		context.method();
		//设置第二种状态
		state.setValue("state2");
		context.method();
	}
}
