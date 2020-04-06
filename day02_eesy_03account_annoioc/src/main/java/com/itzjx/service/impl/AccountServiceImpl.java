package com.itzjx.service.impl;

import com.itzjx.dao.IAccountDao;
import com.itzjx.domain.Account;
import com.itzjx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {

        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {

        accountDao.deleteAccount(id);
    }
}
