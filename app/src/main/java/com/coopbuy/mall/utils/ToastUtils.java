package com.coopbuy.mall.utils;

import android.content.Context;
import android.widget.Toast;

import com.coopbuy.mall.app.CoopBuyApplication;

/**
 * 吐司
 *
 * @author ymb
 *         Create at 2017/7/26 19:16
 */
public class ToastUtils {
    private static Toast toast;
    public static void toastShort(String text) {
        if (toast == null) {
            toast = Toast.makeText(CoopBuyApplication.context, text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }

    public static void toastLong(String text) {
        if (toast == null) {
            toast = Toast.makeText(CoopBuyApplication.context, text, Toast.LENGTH_LONG);
        }
        toast.setText(text);
        toast.show();
    }
}
