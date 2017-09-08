package com.hand.ysl.demo.design.builderDesign.controller;

import com.hand.ysl.demo.design.builderDesign.Interface.PersonBuilder;
import com.hand.ysl.demo.design.builderDesign.Interface.impl.ManBuilder;
import com.hand.ysl.demo.design.builderDesign.Interface.impl.WomenBuilder;
import com.hand.ysl.demo.design.builderDesign.director.PersonDirector;
import com.hand.ysl.demo.design.builderDesign.dto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ernst on 2017/8/18.
 * 建造者模式
 * 将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 1、Builder：为创建一个产品对象的各个部件指定抽象接口。
 2、ConcreteBuilder：实现Builder的接口以构造和装配该产品的各个部件，定义并明确它所创建的表示，并提供一个检索产品的接口。
 3、Director：构造一个使用Builder接口的对象，指导构建过程。
 4、Product：表示被构造的复杂对象。ConcreteBuilder创建该产品的内部表示并定义它的装配过程，包含定义组成部件的类，包括将这些部件装配成最终产品的接口。
 */
@Controller("PersonBuilderController")
@RequestMapping("/builderPerson")
public class PersonBuilderController {

        @RequestMapping(value = "/buildMan", method = RequestMethod.GET)
        public void buildMan() {
            PersonDirector director = new PersonDirector();
            PersonBuilder pb = new ManBuilder();
            Person man = director.constructPerson(pb);
        }

        @RequestMapping(value = "/buildWomen", method = RequestMethod.GET)
        public void buildWomen() {
            PersonDirector pd = new PersonDirector();
            pd.constructPerson(new WomenBuilder());
        }

}
