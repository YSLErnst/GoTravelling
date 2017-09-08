package com.hand.ysl.demo.design.builderDesign.Interface.impl;

import com.hand.ysl.demo.design.builderDesign.Interface.PersonBuilder;
import com.hand.ysl.demo.design.builderDesign.dto.Person;

/**
 * Created by Ernst on 2017/8/18.
 */
public class WomenBuilder implements PersonBuilder{

    Person person;
    @Override
    public void buildHead() {
       person.setHead("女人的头");
    }

    @Override
    public void buildBody() {
        person.setBody("女人的身体");
    }

    @Override
    public void buildFeet() {
        person.setFeet("女人的脚");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
