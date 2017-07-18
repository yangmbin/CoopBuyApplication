package com.coopbuy.mall.utils;

import android.content.Context;
import android.content.Intent;

/**
 * 页面跳转
 * @author ymb
 * Create at 2017/7/18 17:25
 */
public class IntentUtils {

    /**
     * 无参无需返回结果
     * @param context
     * @param activity
     */
    public static void gotoActivity(Context context, Class<?> activity) {
        context.startActivity((new Intent(context, activity)));
    }
}
