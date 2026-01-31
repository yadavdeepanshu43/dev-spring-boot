package com.luv2code.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspects {

    //this is where we add all of our related advices for logging

    //let's start with an @Before advice
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.luv2code.demo.Account))")

//    @Before("execution(* add*(com.luv2code.demo.Account,..))")
    @Before("execution(* com.luv2code.demo.dao.*.*(..))")
    public void beforeAddAcoountAdvice(){
        System.out.println("/n=======>>>> Executing @Before advice on addAccount()");
    }



}
