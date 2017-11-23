package com.coopbuy.mall.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.coopbuy.mall.app.CoopBuyApplication;

/**
 * Created by Administrator on 2017/6/5.
 */
public class DeviceUtils {

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取application中指定的meta-data
     * @return 如果没有获取成功(没有对应值，或者异常)，则返回值为空
     */
    public static String getAppMetaData(Context ctx, String key) {
        if (ctx == null || TextUtils.isEmpty(key)) {
            return null;
        }
        String resultData = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString(key);
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return resultData;
    }

    /**
     * 获取版本号
     * @return
     */
    public static String getVersionName() {
        String versionName = "";
        try {
            String pkName = CoopBuyApplication.getAppContext().getPackageName();
            versionName = CoopBuyApplication.getAppContext().getPackageManager().getPackageInfo(pkName, 0).versionName;
            int versionCode = CoopBuyApplication.getAppContext().getPackageManager().getPackageInfo(pkName, 0).versionCode;
        } catch (Exception e) {
        }
        return versionName;
    }
}
