package com.itzjx.service.impl;

import com.itzjx.dao.IAccountDao;
import com.itzjx.domain.Account;
import com.itzjx.service.IAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
//基于XML对tx:advice标签内部tx：mothod内属性的配置都可在该注解下找到
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }


    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }


    /**
     *  需要读写型事务配置,这里就体现了XML配置的优点：一次配置，所有通用,而注解得挨个配置
     *  但注解又不想XML那样需要繁杂的事务通知tx:advice标签的属性配置，只需要一行开启注解事务的支持
     */
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer.......");
        //2.1.根据名称查询转入账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2.根据名称查询转出账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3.装出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4.装入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5.更新转出账户
        accountDao.updateAccount(source);

        int i=1/0;

        //2.6.更新转入账户
        accountDao.updateAccount(target);
    }
}
