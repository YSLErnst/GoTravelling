package com.hand.ysl.demo.design.builderDesign.Interface;

import com.hand.ysl.demo.design.builderDesign.dto.Person;

/**
 * Created by Ernst on 2017/8/18.
 */
public interface PersonBuilder {
    void buildHead();

    void buildBody();

    void buildFeet();

    Person buildPerson();
}
