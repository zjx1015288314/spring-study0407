package com.itzjx.ui;

import com.itzjx.service.IAccountService;
import com.itzjx.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 获取spring的Ioc核心容器，并根据id获取对象
 *
 * ApplicationContext的三个常用实现类:
 *      ClassPathXmlApplicationContext：可以加载类路径下的配置文件，要求配置文件必须在类路径下(更常用)
 *      FileSystemXmlApplicationContext:可以加载磁盘任意路径下的配置文件，要求必须有访问权限
 *      AnnotationConfigApplicationContext:可以读取注解创建容器
 *
 * 核心容器的两个接口引发的问题：
 * ApplicationContext:      单例对象使用(service,dao)   实际开发中多使用ApplicationContext，比BeanFactory扩展了更多功能
 * 在构建核心容器时，创建对象采取的策略是立即加载的方式，即一读取完配置文件马上创建配置的对象
 * BeanFactory:         多例对象
 * 在构建核心容器时，创建对象采取的策略是延迟加载，即什么时候根据id获取对象什么时候创建对象
 */
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        System.out.println(as);

        //手动释放
        ac.close();


    }

}
