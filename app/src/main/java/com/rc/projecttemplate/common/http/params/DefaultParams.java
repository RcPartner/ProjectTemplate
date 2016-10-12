package com.rc.projecttemplate.common.http.params;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-14 15:44
 */
public class DefaultParams extends BaseParams {

    /**
     *
     * @param appId
     * @param clientVer
     * @param imei
     * @param uuid
     * @param macAddr
     * @param model
     * @param osVer
     * @param chanId
     * @param operator
     * @param nettype
     */
    public DefaultParams(String appId, String clientVer, String imei, String uuid, String macAddr, String model,
                         String osVer, String chanId, String operator, String nettype) {
        params.put("appId", appId);
        params.put("clientVer", clientVer);
        params.put("imei", imei);
        params.put("uuid", uuid);
        params.put("macAddr", macAddr);
        params.put("model", model);
        params.put("osVer", osVer);
        params.put("chanId", chanId);
        params.put("operator", operator);
        params.put("nettype", nettype);
    }
}
