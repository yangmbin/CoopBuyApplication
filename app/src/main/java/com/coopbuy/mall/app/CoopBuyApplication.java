package com.coopbuy.mall.app;

import com.coopbuy.mall.okhttp.OkHttpUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;

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
        // 初始化Fresco
        Fresco.initialize(this);
        // 初始化Bugly
        CrashReport.initCrashReport(getApplicationContext(), "4dced6560c", false);
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
