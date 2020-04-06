package com.itzjx.dao.impl;

import com.itzjx.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImp implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
