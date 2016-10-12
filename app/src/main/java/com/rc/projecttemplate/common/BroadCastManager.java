package com.rc.projecttemplate.common;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import com.rc.projecttemplate.MyApplication;

/**
 * Description: 广播管理类
 *  1）所有的有关广播的方法都应该统一到该类中，方便管理维护；
 *  2）优先使用本地广播，更加高效安全
 *  3）统一风格为sendXXXBC registerXXXBC  unregisterXXXBC
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-09-18 14:28
 */
public class BroadCastManager {

    public static final String ACTION_XXX = "ACTION_XXX";

    public static void sendXXXBC() {
        Intent intent = new Intent(ACTION_XXX);
        LocalBroadcastManager.getInstance(MyApplication.getInstance()).sendBroadcast(intent);
    }

    public static void registerXXXBC(BroadcastReceiver receiver) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_XXX);
        LocalBroadcastManager.getInstance(MyApplication.getInstance()).registerReceiver(receiver, filter);
    }

    public static void unregisterXXXBC(BroadcastReceiver receiver) {
        unregisterLocalBC(receiver);
    }

    /**
     *  反注册广播不直接调用该方法，而应该调用具体的广播的反注册方法，方便管理维护
     * @param receiver 广播接收者
     */
    private static void unregisterLocalBC(BroadcastReceiver receiver){
        LocalBroadcastManager.getInstance(MyApplication.getInstance()).unregisterReceiver(receiver);
    }
}
