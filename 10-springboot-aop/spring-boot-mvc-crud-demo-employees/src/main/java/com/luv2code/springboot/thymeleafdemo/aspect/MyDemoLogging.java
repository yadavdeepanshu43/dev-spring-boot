package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

@Aspect
@Component
public class MyDemoLogging {

    //setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        //display the method we are calling
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n ====> in @Before calling method: " + method);

        //display the arguments to the method

        //get the args
        Object[] args = theJoinPoint.getArgs();

        //loop thru and display it
        for (Object tempArgs : args) {
            myLogger.info("=====> argument: " + tempArgs);
        }
    }

    //add afterReturning advice
    @AfterReturning(
            pointcut = "",
            returning = ""
    )
    public void afterReturining(JoinPoint theJoinPoint, Object theResult){

        //display the method we are returning
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n ====> in @AfterReturning: from method: " + method);

        //display the data returned
        myLogger.info("=====> result: "+ theResult);
    }


}
