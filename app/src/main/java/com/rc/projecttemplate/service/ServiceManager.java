package com.rc.projecttemplate.service;

import com.rc.projecttemplate.service.account.AccountServices;
import com.rc.projecttemplate.service.account.AccountServicesImpl;
import com.rc.projecttemplate.service.goods.GoodsService;
import com.rc.projecttemplate.service.goods.GoodsServiceImpl;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-13 16:09
 */
public class ServiceManager {
    private static AccountServices accountServices;

    private static GoodsService goodsService;

    public static AccountServices getAccountServices() {
        if (accountServices == null) {
            accountServices = new AccountServicesImpl();
        }
        return accountServices;
    }

    public static GoodsService getGoodsService() {
        if (goodsService == null) {
            goodsService = new GoodsServiceImpl();
        }
        return goodsService;
    }
}
