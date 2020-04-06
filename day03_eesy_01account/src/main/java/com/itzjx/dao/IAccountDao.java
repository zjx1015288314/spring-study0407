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

    /**
     *  根据名称查询账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回，没有结果就返回null,如果结果集超过一个就抛异常
     */
    Account findAccountByName(String accountName);
}
