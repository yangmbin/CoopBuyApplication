package com.coopbuy.mall.utils;

/**
 * Created by niu on 2017/11/23- 9:34
 */

import android.view.View;

import com.coopbuy.mall.R;

/**
 * @author niu
 * @time 2017/11/23 9:34
 * @content 设置每个控件可以点击 和颜色变化
 */
public class ViewClickUtil {

    /**
     * @param view    控制控件
     * @param isClick true 可点击
     */
    public static void setViewClickable(View view, Boolean isClick) {
        if (isClick) {
            view.setClickable(true);
            view.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
        } else {
            view.setClickable(false);
            view.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
        }
    }
}
