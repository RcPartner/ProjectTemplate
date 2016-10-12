package com.rc.projecttemplate;

import com.rc.framework.BaseApplication;
import com.rc.framework.imageloader.ImageLoader;

/**
 * Description:
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-07-14 09:49
 */
public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.INSTANCE.init(this);
    }
}
