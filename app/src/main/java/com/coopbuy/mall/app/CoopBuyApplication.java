package com.coopbuy.mall.app;

import android.content.Context;

import com.coopbuy.mall.api.BaseApiClient;
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
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        BaseApiClient.contextInit(context);
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
