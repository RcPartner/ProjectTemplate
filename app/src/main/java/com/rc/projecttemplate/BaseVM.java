package com.rc.projecttemplate;

/**
 * Description: VM 基类
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-08-17 12:07
 */
public class BaseVM<T> {

    protected T dataBinding;

    public BaseVM(T dataBinding) {
        this.dataBinding = dataBinding;
    }
}
