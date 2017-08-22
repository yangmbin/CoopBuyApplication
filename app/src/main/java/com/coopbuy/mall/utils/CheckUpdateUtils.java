package com.coopbuy.mall.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

/**
 * APP检查更新工具类
 * @author ymb
 * Create at 2017/8/21 14:46
 */
public class CheckUpdateUtils {

    /**
     * 判断是否挂载SD卡
     * @return
     */
    public static boolean hasSDCard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
            return true;
        else
            return false;
    }

    /**
     * 获取当前应用版本号
     * @param context
     * @return
     */
    public static int getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
