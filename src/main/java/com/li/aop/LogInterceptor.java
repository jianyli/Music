package com.li.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
    @Before("execution(* com.li.controller.*.*(..))")
    public void before() {
        System.out.println("-------------------进入controller层的时间为"+System.currentTimeMillis());
    }
    @After("execution(* com.li.controller.*.*(..))")
    public void after() {
        System.out.println("-------------------退出时间为" + System.currentTimeMillis());
    }
}
