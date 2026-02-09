package com.luv2code.demo.aspects;

import com.luv2code.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.demo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        //print out the method we are advicing on
        String method = theProceedingJoinPoint.getSignature().toString();
        System.out.println("\n====> Executing @Around on method: "+ method);

        //get begin time stamp
        Long begin = System.currentTimeMillis();

        // execute the method
        Object result = theProceedingJoinPoint.proceed();

        //get end timestamp
        Long end = System.currentTimeMillis();

        // compute duration and display it
        Long duration = end - begin;

        System.out.println("\n=== Duration: "+ duration/1000.0 +"Seconds");

        return result;
    }

    @After("execution(* com.luv2code.demo.dao.AccountDAO.findAccount(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint)
    {
        //print put which method we are advicing on
        String method = theJoinPoint.getSignature().toString();
        System.out.println("\n====> Executing @After(finally) on method: "+ method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.demo.dao.AccountDAO.findAccount(..))",
            throwing="theExe"
    )
    public void afterThrowingFindAccountAdvice(
            JoinPoint theJoinPoint,
            Throwable theExe
    ){
            //print put which method we are advicing on
            String method = theJoinPoint.getSignature().toString();
        System.out.println("\n====> Executing @AfterThrowing on method: "+ method);

        //log the exeption
        System.out.println("\n\n====> The Exception is: " +theExe);
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.demo.dao.AccountDAO.findAccount(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        //print out which method we are advicing on
        String method = theJoinPoint.getSignature().toString();
        System.out.println("\n====> Executing @AfterReturning on method: "+ method);

        //print out the results of the method call
        System.out.println("\n====> Result is: "+ result);

        //let's post-process the data.. let's modify it :-)
            convertAccountNameToUpperCase(result);
        System.out.println("\n====> Result is: "+ result);
        //convert the names to uppercase

    }

    private void convertAccountNameToUpperCase(List<Account> result) {
       //loop through accounts
        for(Account tempAccount: result) {

            //get uppercase version of name
            String theUppercase= tempAccount.getName().toUpperCase();

            //update the name on the account
            tempAccount.setName(theUppercase);
        }
    }

    @Before("com.luv2code.demo.aspects.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature= (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+ methodSignature);

        //display the method arguments

        //get args
        Object[] args =theJoinPoint.getArgs();

        //Loop the args
        for(Object tempargs: args){
            System.out.println(tempargs);

            if(tempargs instanceof Account)
            {
                //downcaste the print Account specific stuff
                Account theAccount =(Account) tempargs;

                System.out.println("account name: " +theAccount.getName());
                System.out.println("account Level: " +theAccount.getLevel());

            }
        }

    }

}
