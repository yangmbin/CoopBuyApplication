package com.coopbuy.mall.widget.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;
import com.coopbuy.mall.ui.module.home.activity.LocationActivity;
import com.coopbuy.mall.ui.module.home.activity.SearchActivity;
import com.coopbuy.mall.utils.IntentUtils;

/**
 * 主页顶部bar
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class NavHomeBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private LinearLayout ll_location, ll_search;
    private Context mContext;

    public NavHomeBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.nav_home_top, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        ll_location = mView.findViewById(R.id.ll_location);
        ll_search = mView.findViewById(R.id.ll_search);
        ll_location.setOnClickListener(this);
        ll_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_location:
                IntentUtils.gotoActivity(mContext, LocationActivity.class);
                break;
            case R.id.ll_search:
                IntentUtils.gotoActivity(mContext, SearchActivity.class);
                break;
        }
    }
}
