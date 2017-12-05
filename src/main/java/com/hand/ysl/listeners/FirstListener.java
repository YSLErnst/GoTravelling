package com.hand.ysl.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Ernst on 2017/11/30.
 * 启动顺序： 监听器>过滤器>servlet
 */
public class FirstListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContext) {
        String initParam = servletContext.getServletContext().getInitParameter("yslParam");
        System.out.println("context initialized-----------------initParam:"+initParam);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context destroyed--------------------");
    }
}
