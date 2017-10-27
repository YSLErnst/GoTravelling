package com.hand.ysl.demo.design.mediatorDesign.Interface.impl;

import com.hand.ysl.demo.design.mediatorDesign.Interface.Mediator;
import com.hand.ysl.demo.design.mediatorDesign.Interface.User;

/**
 * Created by Ernst on 2017/10/23.
 */
public class User1 extends User{
    public User1(Mediator mediator){
        super(mediator);
    }
    @Override
    public void work() {
        System.out.println("user1 works");
    }
}
