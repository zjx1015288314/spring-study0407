package com.itzjx.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的类,它里面提供了公共的代码
 */
@Configuration
@Component("logger")
@EnableAspectJAutoProxy
@Aspect  //表示当前类为切面类
public class Logger {
    @Pointcut("execution(* com.itzjx.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志.......");
    }
    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志.......");
    }
    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志.......");
    }
    /**
     * 最终通知
     */
    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志.......");
    }

    /**
     * 环绕通知
     * 问题：当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
     * 解决：
     *      Spring框架为我们提供了一个接口，ProceedingJoinPoint,该接口有一个方法proceed().此方法就相当于
     *      明确调用切入点方法。该方法可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类
     * spring中的环绕通知：
     *      它是spring提供的一种可以在代码中手动控制增强方法何时执行的通知
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();  //得到方法的返回值
            System.out.println("通知Logger类中的aroundPrintLog方法开始记录日志.......前置");
            pjp.proceed(args); //明确调用业务层方法(切入点)
            System.out.println("通知Logger类中的aroundPrintLog方法开始记录日志.......后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("通知Logger类中的aroundPrintLog方法开始记录日志.......异常");
            throw new RuntimeException(throwable );
        }finally {
            System.out.println("通知Logger类中的aroundPrintLog方法开始记录日志.......最终");
        }
    }

}
