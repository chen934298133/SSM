package com.chen.diy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.chen.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("======before the Code======");
    }
    @After("execution(* com.chen.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("======after the Code======");
    }
    @Around("execution(* com.chen.service.UserServiceImpl.*(..))")
    public void around(){

    }
}
