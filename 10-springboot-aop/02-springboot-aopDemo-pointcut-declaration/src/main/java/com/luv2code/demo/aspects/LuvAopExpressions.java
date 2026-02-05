package com.luv2code.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.luv2code.demo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.demo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.luv2code.demo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}