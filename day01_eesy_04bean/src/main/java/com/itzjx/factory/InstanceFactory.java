package com.itzjx.factory;

import com.itzjx.service.IAccountService;
import com.itzjx.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public IAccountService getService(){
        return new AccountServiceImpl();
    }
}
