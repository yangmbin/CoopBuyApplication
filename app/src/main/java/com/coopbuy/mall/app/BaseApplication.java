package com.coopbuy.mall.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.coopbuy.mall.api.BaseApiClient;

/**
 * 基类Application
 *
 * @author ymb
 *         Create at 2017/7/14 15:33
 */
public class BaseApplication extends MultiDexApplication {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        baseApplication = this;
        BaseApiClient.contextInit(getApplicationContext());
    }

    public static Context getAppContext() {
        return baseApplication;
    }

    public static Resources getAppResources() {
        return baseApplication.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}