
package com.rc.projecttemplate.service.account;


import com.rc.framework.service.ServicesCallback;

/**
 * Description: Author: Caizemingg Email:caizemingg@163.com Date: 2016-07-13
 * 14:31
 */
public interface AccountServices {

    void login(String userName, String pwd, ServicesCallback callback);
}
