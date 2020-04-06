package com.itzjx.service.impl;

import com.itzjx.service.IAccuontService;

public class AccountServiceImpl implements IAccuontService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleleAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
