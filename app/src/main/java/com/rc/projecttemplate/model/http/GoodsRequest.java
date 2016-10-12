package com.rc.projecttemplate.model.http;/**
 * Created by Czm on 2016/8/5.
 */

import com.rc.projecttemplate.model.resopnse.AnnouncedGoodsActivityResponse;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-08-05 21:01
 */
public interface GoodsRequest {

    @GET("/Activity/preUnveiled")
    void getAnnounceGoodsList(@Query("page") int page, @Query("pageSize") int pageSize,
                              Callback<AnnouncedGoodsActivityResponse> callback);
}
