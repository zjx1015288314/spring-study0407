package com.itzjx.test;

import com.itzjx.domain.Account;
import com.itzjx.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    IAccountService as;

    @Test
    public void testFindAll(){
        //3.执行
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
    @Test
    public void testFindOne(){
        //3.执行
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        //3.执行
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //3.执行
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //3.执行
        as.deleteAccount(4);
    }
}
