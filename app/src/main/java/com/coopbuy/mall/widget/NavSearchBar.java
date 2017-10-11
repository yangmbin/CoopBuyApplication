package com.coopbuy.mall.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;

/**
 * 顶部搜索栏
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class NavSearchBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private FrameLayout fl_goback;
    private LinearLayout ll_search;
    private Context mContext;

    public NavSearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.nav_search_top, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        fl_goback = (FrameLayout) mView.findViewById(R.id.go_back);
        ll_search = (LinearLayout) mView.findViewById(R.id.ll_search);
        fl_goback.setOnClickListener(this);
        ll_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                ((Activity) mContext).finish();
                break;
            case R.id.ll_search:
                break;
        }
    }
}
