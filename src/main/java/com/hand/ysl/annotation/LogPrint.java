package com.hand.ysl.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Ernst on 2017/12/1.
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Component
public @interface LogPrint {
}
