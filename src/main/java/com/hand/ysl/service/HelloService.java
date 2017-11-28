package com.hand.ysl.service;

import org.springframework.security.access.annotation.Secured;

/**
 * Created by Ernst on 2017/11/22.
 */
public interface HelloService {
    /*@Secured({"ROLE_USER","ROLE_ADMIN"})*/
    String sayHello(String name);

    /*@Secured({"ROLE_ADMIN"})*/
    String sayBye(String name);
}
