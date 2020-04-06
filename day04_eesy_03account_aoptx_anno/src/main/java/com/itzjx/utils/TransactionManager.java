package com.itzjx.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务管理相关的工具类，包含了：开启事务，提交事务，回滚事务和释放连接
 */
@Component("txManager")
@Aspect //表明当前类是切面类
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.itzjx.service.impl.*.*(..))")
    private void pt1(){};

    /**
     * 开启事务
     */
    @Before("pt1()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
    @AfterReturning("pt1()")
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    @After("pt1()")
    public void release(){
        try {
            connectionUtils.getThreadConnection().close(); //并非销毁，而是还回连接池中(与线程池同理)
            connectionUtils.removeConnection(); //解绑
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //@Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();
            this.beginTransaction();
            rtValue = pjp.proceed(args);
            this.commit();
            return rtValue;
        }catch (Throwable t){
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            this.release();
        }
    }
}
