package com.itzjx.service;

/**
 * 账户的业务层接口
 */
public interface IAccuontService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @return
     */
    int deleleAccount();
}
