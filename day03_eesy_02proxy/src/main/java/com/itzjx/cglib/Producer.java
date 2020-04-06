package com.itzjx.cglib;

import com.itzjx.proxy.IProducer;

/**
 * 一个生产者
 */
public class Producer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){

        System.out.println("销售产品，拿到钱:" + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("售后服务，拿到钱:" + money);
    }
}
