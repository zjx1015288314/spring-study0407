package com.itzjx.service.impl;

import com.itzjx.dao.IAccountDao;
import com.itzjx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 * 曾经XML的配置:
 * <bean id="accountService" class="com.itzjx.service.impl.AccountServiceImpl" scope=""
 *      init-method="" destory-method="">
 *      <property name="" value=""| ref=""></property>
 * </bean>
 *
 * 注解分为：
 *  用于创建对象的：他们的作用和在XML配置文件中编写一个<bean>标签实现的功能一样
 *      @Component：将当前类存入spring容器中.其value属性用于指定bean的id，不写时默认值是当前类名且首字母小写
 *      @Controller:一般用于表现层(不对应也可以，三个的作用一样)
 *      @Service ：一般用在业务层(不对应也可以，三个的作用一样)
 *      @Repository：一般用在持久层(不对应也可以，三个的作用一样)
 *      以上三个注解他们的作用和属性与Component是一模一样的,他们三个是spring框架为我们提供明确的三层使用的注释，
 *      使我们的三层对象更加清晰
 *  用于注入数据的：作用与<bean>标签写一个constructor-arg标签(构造器注入)/property标签(set方法注入)的作用是一样的
 *      @Autowired:自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配(包括继承关系)，就可以注入成功
 *      如果Ioc容器中没有任何bean的类型和要注入的变量类型匹配(包括继承关系)，则注入失败；
 *      如果Ioc容器有多个类型匹配时，则再根据变量名称去匹配bean对象的id，一致则返回，如果找不到则抛出异常
 *          出现位置:可以在变量上，也可以在方法上
 *      @Qualifier:在按照类型注入的基础上，再按照名称注入。它在给类成员注入时必须与Autowired搭配使用，但是给方法参数注入时可以
 *          属性：value，指定注入bean的id
 *      @Resource:直接按照bean的id注入，它可以独立使用
 *          属性：name，指定bean的id
 *      以上三个注解只能注入其他bean类型的数据，而基本类型和String类型无法使用以上注解。
 *      另外，集合类型的注入只能通过XML实现
 *
 *      @Value：用于注入基本类型和String类型的数据
 *          属性：value，用于指定数据的值，它可以使用spring中的SpEl
 *              SpEl的写法：${表达式}
 *
 *  用于改变作用范围的：作用与在bean标签中写一个scope标签的作用是一样的
 *      @Scope：指定bean的作用范围
 *          属性：value，指定范围的取值。常用取值:singleton,prototype
 *  和生命周期相关的：作用与在bean标签中写一个init-method与destory-method标签的作用是一样的  只了解
 *      PreDestory:指定销毁方法
 *      PostConstruct：指定初始化方法
 */
@Controller(value = "accountService")   //只给一个属性赋值且属性名为value时可省略
//@Scope("prototype") 多例对象spring容器不负责，交给垃圾回收器
public class AccountServiceImpl implements IAccountService {
//    @Autowired   //使用注解注入时。set方法就不是必须的了
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    @PostConstruct
    public void init(){
        System.out.println("初始化执行");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁执行");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
