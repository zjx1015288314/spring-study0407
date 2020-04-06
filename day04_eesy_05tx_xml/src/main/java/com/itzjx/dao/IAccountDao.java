package com.itzjx.dao;

import com.itzjx.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);
    /**
     * 根据名称查询账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
