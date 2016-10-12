
package com.rc.projecttemplate.service.account;


import com.rc.framework.http.HttpClient;
import com.rc.framework.service.ServicesCallback;
import com.rc.projecttemplate.common.http.HttpUrlManager;
import com.rc.projecttemplate.common.http.params.LoginParams;

/**
 * Description: Author: Caizemingg Email:caizemingg@163.com Date: 2016-07-13
 * 14:36
 */
public class AccountServicesImpl implements AccountServices {
    @Override
    public void login(String userName, String pwd, final ServicesCallback callback) {
        LoginParams params = new LoginParams(userName, pwd);
        HttpClient.INSTANCE.get(params.getUrl(HttpUrlManager.LOGIN), callback);
    }
}
