package com.hand.ysl.demo.design.mediatorDesign.Interface;

/**
 * Created by Ernst on 2017/10/23.
 */
public abstract class User {
    private Mediator mediator;

    public Mediator getMediator(){
        return mediator;
    }

    public User(Mediator mediator){
        this.mediator = mediator;
    }

    public abstract void work();
}
