package com.coopbuy.mall.app;

import com.coopbuy.mall.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Application类
 *
 * @author ymb
 *         Create at 2017/7/14 10:29
 */
public class CoopBuyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化OkHttp
        initOkHttp();
    }

    /**
     * 初始化OkHttp
     */
    private void initOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20000L, TimeUnit.MILLISECONDS)
                .readTimeout(20000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
