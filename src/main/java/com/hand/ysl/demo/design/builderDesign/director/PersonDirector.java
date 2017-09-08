package com.hand.ysl.demo.design.builderDesign.director;

import com.hand.ysl.demo.design.builderDesign.Interface.PersonBuilder;
import com.hand.ysl.demo.design.builderDesign.dto.Person;

/**
 * Created by Ernst on 2017/8/18.
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder builder){
        builder.buildHead();
        builder.buildBody();
        builder.buildFeet();
        return builder.buildPerson();
    }
}
