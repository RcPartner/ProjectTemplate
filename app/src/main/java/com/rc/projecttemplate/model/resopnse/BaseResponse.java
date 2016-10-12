package com.rc.projecttemplate.model.resopnse;

import java.io.Serializable;

/**
 * Description: 返回结果基类
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-13 16:26
 */
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -5394226476860144632L;

    public int status;

    public int errCode;

    public String errMsg;

    public String error;

    public T data;

    public boolean isSuccess() {
        if (status == 1 && errCode == 0)
            return true;
        return false;
    }
}
