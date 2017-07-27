package com.coopbuy.mall.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 吐司
 * @author ymb
 * Create at 2017/7/26 19:16
 */
public class ToastUtils {
    private static Toast toast;

   public static void textToast(Context context, String text) {
       if (toast == null) {
           toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
       }
       toast.setText(text);
       toast.show();
   }
}
