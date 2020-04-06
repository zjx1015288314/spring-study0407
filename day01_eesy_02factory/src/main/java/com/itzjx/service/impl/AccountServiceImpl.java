package com.itzjx.service.impl;

import com.itzjx.dao.IAccountDao;
import com.itzjx.dao.impl.AccountDaoImp;
import com.itzjx.factory.BeanFactory;
import com.itzjx.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImp();

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
