package com.hand.ysl.demo.design.observerDesign.controllers;
import com.hand.ysl.demo.design.facadeDesign.dto.Computer;
import com.hand.ysl.demo.design.observerDesign.Interface.Subject;
import com.hand.ysl.demo.design.observerDesign.dto.MySubject;
import com.hand.ysl.demo.design.observerDesign.dto.Observer1;
import com.hand.ysl.demo.design.observerDesign.dto.Observer2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 * ：MySubject类就是我们的主对象，Observer1和Observer2是依赖于MySubject的对象，当MySubject变化时，Observer1和Observer2必然变化。AbstractSubject类中定义着需要监控的对象列表，
 * 可以对其进行修改：增加或删除被监控对象，且当MySubject变化时，负责通知在列表内存在的对象
 *
 */
@Controller("ObserverController")
@RequestMapping("/observer")
public class ObserverController {

	@RequestMapping(value = "/observe", method = RequestMethod.GET)
	public void observe() {
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());
		sub.operation();
	}
}
