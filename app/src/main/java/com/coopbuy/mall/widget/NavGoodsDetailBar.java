package com.coopbuy.mall.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

/**
 * 商品详情顶部
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class NavGoodsDetailBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private Context mContext;
    private SlidingTabLayout slidingTabLayout;
    private FrameLayout fl_goback;

    public NavGoodsDetailBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.nav_goods_detail_top, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        slidingTabLayout = (SlidingTabLayout) mView.findViewById(R.id.tablayout);
        fl_goback = (FrameLayout) mView.findViewById(R.id.go_back);

        fl_goback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                ((Activity) mContext).finish();
                break;
        }
    }

    public void setViewPager(ViewPager viewPager, String[] titles, FragmentActivity fragmentActivity, ArrayList<Fragment> fragments) {
        slidingTabLayout.setViewPager(viewPager, titles, fragmentActivity, fragments);
    }
}
