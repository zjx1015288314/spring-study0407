package com.itzjx.ui;

import com.itzjx.factory.BeanFactory;
import com.itzjx.service.IAccountService;
import com.itzjx.service.impl.AccountServiceImpl;

/**
 * 模拟表现出，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
        }
//        accountService.saveAccount();
    }

}
