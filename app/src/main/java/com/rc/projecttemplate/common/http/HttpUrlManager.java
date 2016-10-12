
package com.rc.projecttemplate.common.http;

/**
 * Description: Author: Caizemingg Email:caizemingg@163.com Date: 2016-07-13
 * 15:13
 */
public class HttpUrlManager {

    public static String HOST = "http://10.17.174.55:8192";

    private static String PREFIX = "";

    public static String LOGIN = "/login";

    public static String GET_ANNOUNCE_GOODS_LIST = "/Activity/preUnveiled";

    static {
        init();
    }

    private static void init() {
        LOGIN = HOST + PREFIX + LOGIN;
        GET_ANNOUNCE_GOODS_LIST = HOST + PREFIX + GET_ANNOUNCE_GOODS_LIST;
    }
}
