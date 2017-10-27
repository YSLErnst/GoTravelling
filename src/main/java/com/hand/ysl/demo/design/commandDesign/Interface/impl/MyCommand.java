package com.hand.ysl.demo.design.commandDesign.Interface.impl;

import com.hand.ysl.demo.design.commandDesign.Interface.Command;
import com.hand.ysl.demo.design.commandDesign.dto.Receiver;

/**
 * Created by Ernst on 2017/10/24.
 */
public class MyCommand implements Command{
    private Receiver receiver;

    public MyCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void     exec() {
       receiver.action();
    }
}
