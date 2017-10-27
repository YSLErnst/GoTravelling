package com.hand.ysl.demo.design.mementoDesign.controller;
import com.hand.ysl.demo.design.mementoDesign.dto.Original;
import com.hand.ysl.demo.design.mementoDesign.dto.Storage;
import com.hand.ysl.demo.design.observerDesign.Interface.Subject;
import com.hand.ysl.demo.design.observerDesign.dto.MySubject;
import com.hand.ysl.demo.design.observerDesign.dto.Observer1;
import com.hand.ysl.demo.design.observerDesign.dto.Observer2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ysl
 * 备忘录模式
 * 三个类 原始类A/备忘录类B/存储备忘录的类C
 * 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些。
 * 通俗的讲下：假设有原始类A，A中有各种属性，A可以决定需要备份的属性，
 * 备忘录类B是用来存储A的一些内部状态，类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作。
 *
 */
@Controller("MementoController")
@RequestMapping("/memento")
public class MementoController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void memento() {
		Original original = new Original("ysl");
		System.out.println("修改前："+original.getValue());

		Storage storage = new Storage(original.createMemento());

		original.setValue("yslhahaha");
		System.out.println("修改后：" + original.getValue());

		original.restoreMemento(storage.getMemento());

		System.out.println("恢复备份后："+original.getValue());
	}
}
