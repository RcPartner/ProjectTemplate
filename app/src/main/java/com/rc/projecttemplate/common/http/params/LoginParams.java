
package com.rc.projecttemplate.common.http.params;


/**
 * Description: Author: Caizemingg Email:caizemingg@163.com Date: 2016-07-13
 * 15:41
 */
public class LoginParams extends BaseParams {

    public LoginParams(String userName, String pwd) {
        params.put("loginName", userName);
        params.put("loginPwd", pwd);
    }

}
