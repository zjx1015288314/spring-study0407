package com.itzjx.service;

import com.itzjx.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
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
     *
     * @param sourceName  转出账户名称
     * @param targetName   装出账户名称
     * @param money     转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
