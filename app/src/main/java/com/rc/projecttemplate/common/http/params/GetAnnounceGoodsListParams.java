
package com.rc.projecttemplate.common.http.params;


/**
 * Description: Author: Caizemingg Email:caizemingg@163.com Date: 2016-07-13
 * 15:41
 */
public class GetAnnounceGoodsListParams extends BaseParams {

    public GetAnnounceGoodsListParams(int page, int pageSize) {
        params.put("page", page + "");
        params.put("pageSize", pageSize + "");
    }

}
