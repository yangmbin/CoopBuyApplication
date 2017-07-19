package com.coopbuy.mall.api;

import com.coopbuy.mall.okhttp.OkHttpUtils;
import com.coopbuy.mall.okhttp.callback.StringCallback;

/**
 * api
 * @author ymb
 * Create at 2017/7/14 14:29
 */
public class api {
    public static final String HOST = "http://dev.guinong.com:8810/";

    public static void requestTestData(StringCallback callback) {
        OkHttpUtils
                .get()
//                .url("http://dev.guinong.com:8810/api/SpokesMan/GetSpokesInfo")
                .url("http://dev.guinong.com:8810/api/Home/Get?pageNo=1&pageSize=11")
                .build()
                .execute(callback);
    }
}
