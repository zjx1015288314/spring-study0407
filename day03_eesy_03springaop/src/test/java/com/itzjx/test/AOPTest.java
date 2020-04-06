package com.itzjx.test;

import com.itzjx.service.IAccuontService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP配置
 */
public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccuontService as = (IAccuontService) ac.getBean("accountService");
        //3.执行
        as.saveAccount();
        as.updateAccount(1);
        as.deleleAccount();

    }
}
