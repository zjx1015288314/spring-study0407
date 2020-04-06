package com.itzjx.service.impl;

import com.itzjx.dao.IAccountDao;
import com.itzjx.dao.impl.AccountDaoImp;
import com.itzjx.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImp();

    public AccountServiceImpl(){
        System.out.println("对象被创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
