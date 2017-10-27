package com.hand.ysl.demo.design.responsibilityDesign.dto;

import com.hand.ysl.demo.design.responsibilityDesign.Interface.Handler;

/**
 * Created by Ernst on 2017/10/9.
 */
public abstract class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
