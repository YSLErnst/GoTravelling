package com.hand.ysl.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Ernst on 2017/12/1.
 */
@WebListener
public class OnlinePeople implements HttpSessionListener{
    private int onlineNumber;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        onlineNumber++;
        httpSessionEvent.getSession().getServletContext().setAttribute("onlinePeople",onlineNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        onlineNumber--;
        httpSessionEvent.getSession().getServletContext().setAttribute("onlinePeople",onlineNumber);
    }

    public int getOnlineNumber() {
        return onlineNumber;
    }

    public void setOnlineNumber(int onlineNumber) {
        this.onlineNumber = onlineNumber;
    }
}
