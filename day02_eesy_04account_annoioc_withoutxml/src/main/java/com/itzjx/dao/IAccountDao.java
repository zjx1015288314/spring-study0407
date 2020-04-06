package com.itzjx.dao;

import com.itzjx.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();
    /**
     * 查询一个
     * @param id
     */
    Account findAccountById(Integer id);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);
    /**
     * 删除
     * @param id
     */
    void deleteAccount(Integer id);
}
