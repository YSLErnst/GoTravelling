package com.hand.ysl.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.Enumeration;

/**
 * Created by Ernst on 2017/11/30.
 */
public class MyHttpRequestListener implements ServletRequestListener{
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        Enumeration<String> params = servletRequestEvent.getServletRequest().getParameterNames();
        while (params.hasMoreElements()) {
            String paramKey = (String) params.nextElement();
            String paramValue = servletRequestEvent.getServletRequest().getParameter(paramKey);
            System.out.println("参数是"+paramKey+":"+paramValue);
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }
}
