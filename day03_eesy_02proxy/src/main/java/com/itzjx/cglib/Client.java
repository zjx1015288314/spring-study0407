package com.itzjx.cglib;

import com.itzjx.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        /**
         * 动态代理：
         *      特点：字节码随用随创建，随用随加载
         *      作用：不修改源码的基础上对方法增强
         *      分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         *      基于子类的动态代理：
         *          涉及的类;Proxy
         *          提供者：第三方cglib库
         *          如何创建：使用Ehancer类中的create()方法，该方法的参数：
         *              @Class:字节码，指定被代理对象的字节码
         *              @Callback:用于提供增强的代码。我们一般是写一个该接口的子接口MethodInterceptor的实现类，
         *              通常情况下是匿名内部类，但不是必须的。此接口的实现类都是谁用谁写
         *          创建代理对象的要求：被代理类不能是最终类
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param args
             *      以上三个参数和基于接口的代理中invoke方法的参数一样
             * @param methodProxy   当前方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码
                Object returnValue = null;
                //1.获取方法执行的参数
                Float money = (Float) args[0];
                //2.判断当前方法是不是销售
                if("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(10000f);
    }
}
