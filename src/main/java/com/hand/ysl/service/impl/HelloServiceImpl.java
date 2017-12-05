package com.hand.ysl.service.impl;

import com.hand.ysl.annotation.LogPrint;
import com.hand.ysl.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Ernst on 2017/11/22.
 */
@Component
public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String name) {
        return "您好，"+name;
    }

    @Override
    @LogPrint
    public String sayBye(String name) {
        System.out.println("再见");
        return "再见，"+name;
    }
}
