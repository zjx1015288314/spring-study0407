package com.itzjx.service;

import com.itzjx.domain.Account;

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 根据id查询账户信息
     */
    Account findAccountById(Integer id);

    /**
     * 转账
     * @param sourceName 转出账户名
     * @param targetName 转入账户名
     * @param money 金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
