package com.hand.ysl.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Ernst on 2017/12/1.
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("@annotation(com.hand.ysl.annotation.LogPrint)")
    public void printLog(){
        System.out.println("logs------------printed");
    }

    @Before("printLog()")
    public void beforeLog(){
        System.out.println("============before logs");
    }

    @After("printLog()")
    public void afterLog(){
        System.out.println("======================after   logs");
    }
}
