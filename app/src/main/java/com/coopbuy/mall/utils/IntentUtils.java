package com.coopbuy.mall.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * 页面跳转
 * @author ymb
 * Create at 2017/7/18 17:25
 */
public class IntentUtils {

    public static final String PARAM1 = "param1";
    public static final String PARAM2 = "param2";

    /**
     * 无参无需返回结果
     * @param context
     * @param activity
     */
    public static void gotoActivity(Context context, Class<?> activity) {
        context.startActivity((new Intent(context, activity)));
    }

    /**
     * 带一个参数无返回结果
     * @param context
     * @param activity
     * @param param1
     */
    public static void gotoActivity(Context context, Class<?> activity, String param1) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(PARAM1, param1);
        context.startActivity(intent);
    }
}
