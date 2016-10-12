package com.rc.projecttemplate.service.goods;

import com.rc.framework.service.ServicesCallback;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-14 11:25
 */
public interface GoodsService {
    void getAnnounceGoodsList(int page, int pageSize, ServicesCallback callback);

    void startCountDownAnnounceGoodsList();
}
