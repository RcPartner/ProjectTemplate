package com.rc.projecttemplate.common.http.params;

import android.content.Context;
import android.os.Build;

import com.rc.framework.http.params.RcRequestParams;
import com.rc.framework.util.AppInfoUtil;
import com.rc.framework.util.NetworkUtil;
import com.rc.framework.util.SystemInfoUtil;
import com.rc.projecttemplate.MyApplication;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-14 15:41
 */
public class BaseParams extends RcRequestParams {

    public BaseParams() {
        Context context = MyApplication.getInstance();
        params.put("appId", "8");
        params.put("clientVer", AppInfoUtil.getVersionCode(context) + "");
        params.put("imei", SystemInfoUtil.getIMEI(context));
        params.put("uuid", SystemInfoUtil.getUUID(context));
        params.put("macAddr", SystemInfoUtil.getWLANMacAddress(context));
        params.put("model", SystemInfoUtil.getPhoneModel());
        params.put("osVer", Build.VERSION.RELEASE);
        params.put("chanId", "2");
        params.put("operator", SystemInfoUtil.getOperatorsType(context) + "");
        params.put("nettype", NetworkUtil.getNetWorkType(context) + "");
    }
}
