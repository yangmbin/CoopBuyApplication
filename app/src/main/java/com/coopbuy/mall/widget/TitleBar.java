package com.coopbuy.mall.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;

/**
 *
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class TitleBar extends RelativeLayout {

    private View mView;
    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.title_bar, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);
    }
}
