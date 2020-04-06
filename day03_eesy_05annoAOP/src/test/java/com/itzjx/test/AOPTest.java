package com.itzjx.test;

import com.itzjx.service.IAccuontService;
import com.itzjx.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP配置
 */
public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(AccountServiceImpl.class);
        //2.获取对象
        IAccuontService as = (IAccuontService) ac.getBean("accountService");
        //3.执行
        as.saveAccount();

    }
}
