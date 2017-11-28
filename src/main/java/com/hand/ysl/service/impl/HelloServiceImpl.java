package com.hand.ysl.service.impl;

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

    @Autowired
    private UserCache userCache;

    @Override
    public String sayHello(String name) {
        return "您好，"+name;
    }

    @Override
    public String sayBye(String name) {
        return "再见，"+name;
    }
}
