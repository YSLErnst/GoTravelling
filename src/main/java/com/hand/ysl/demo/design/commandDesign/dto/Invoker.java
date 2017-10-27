package com.hand.ysl.demo.design.commandDesign.dto;

import com.hand.ysl.demo.design.commandDesign.Interface.Command;

/**
 * Created by Ernst on 2017/10/24.
 */
public class Invoker {
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void invoke(){
        command.exec();
    }
}
