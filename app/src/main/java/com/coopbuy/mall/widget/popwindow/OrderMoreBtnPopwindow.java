package com.coopbuy.mall.widget.popwindow;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.coopbuy.mall.R;
import com.coopbuy.mall.utils.ScreenUtils;

/**
 * 订单列表更多按钮弹窗
 * @author ymb
 * Create at 2017/10/18 13:43
 */
public class OrderMoreBtnPopwindow extends PopupWindow {

    private Context mContext;

    public OrderMoreBtnPopwindow(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        View contentView = LayoutInflater.from(context).inflate(R.layout.pop_order_more_btn, null);
        setContentView(contentView);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
    }

    public void showWindow(View anchor) {
        if (isShowing())
            dismiss();
        else
            showAsDropDown(anchor, -ScreenUtils.dip2px(mContext, 30), 0);
    }
}
