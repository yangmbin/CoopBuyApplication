package com.coopbuy.mall.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * 基类Application
 * @author ymb
 * Create at 2017/7/14 10:38
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
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