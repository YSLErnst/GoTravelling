package com.hand.ysl.demo.design.mediatorDesign.Interface.impl;

import com.hand.ysl.demo.design.mediatorDesign.Interface.Mediator;
import com.hand.ysl.demo.design.mediatorDesign.Interface.User;

/**
 * Created by Ernst on 2017/10/23.
 */
public class MyMediator implements Mediator{
    private User user1;

    private User user2;

    @Override
    public void createMediator() {
        user1 = new User1(this);
        user2 = new User2(this);
    }

    @Override
    public void workAll() {
        user1.work();
        user2.work();
    }
}
