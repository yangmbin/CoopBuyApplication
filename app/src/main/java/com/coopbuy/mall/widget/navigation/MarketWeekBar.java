package com.coopbuy.mall.widget.navigation;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;

/**
 * 赶场星期条
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class MarketWeekBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private LinearLayout mLLDay1, mLLDay2, mLLDay3, mLLDay4, mLLDay5, mLLDay6, mLLDay7;
    private View mIndicator1, mIndicator2, mIndicator3, mIndicator4, mIndicator5, mIndicator6, mIndicator7;
    private ViewPager mViewPager;

    public MarketWeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.market_week_bar, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        mLLDay1 = (LinearLayout) findViewById(R.id.ll_day_1);
        mLLDay2 = (LinearLayout) findViewById(R.id.ll_day_2);
        mLLDay3 = (LinearLayout) findViewById(R.id.ll_day_3);
        mLLDay4 = (LinearLayout) findViewById(R.id.ll_day_4);
        mLLDay5 = (LinearLayout) findViewById(R.id.ll_day_5);
        mLLDay6 = (LinearLayout) findViewById(R.id.ll_day_6);
        mLLDay7 = (LinearLayout) findViewById(R.id.ll_day_7);

        mIndicator1 = findViewById(R.id.indicator_1);
        mIndicator2 = findViewById(R.id.indicator_2);
        mIndicator3 = findViewById(R.id.indicator_3);
        mIndicator4 = findViewById(R.id.indicator_4);
        mIndicator5 = findViewById(R.id.indicator_5);
        mIndicator6 = findViewById(R.id.indicator_6);
        mIndicator7 = findViewById(R.id.indicator_7);

        mLLDay1.setOnClickListener(this);
        mLLDay2.setOnClickListener(this);
        mLLDay3.setOnClickListener(this);
        mLLDay4.setOnClickListener(this);
        mLLDay5.setOnClickListener(this);
        mLLDay6.setOnClickListener(this);
        mLLDay7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_day_1:
                setIndicatorPosition(1);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.ll_day_2:
                setIndicatorPosition(2);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.ll_day_3:
                setIndicatorPosition(3);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.ll_day_4:
                setIndicatorPosition(4);
                mViewPager.setCurrentItem(3);
                break;
            case R.id.ll_day_5:
                setIndicatorPosition(5);
                mViewPager.setCurrentItem(4);
                break;
            case R.id.ll_day_6:
                setIndicatorPosition(6);
                mViewPager.setCurrentItem(5);
                break;
            case R.id.ll_day_7:
                setIndicatorPosition(7);
                mViewPager.setCurrentItem(6);
                break;
        }
    }

    public void setIndicatorPosition(int position) {
        switch (position) {
            case 1:
                mIndicator1.setVisibility(VISIBLE);
                mIndicator2.setVisibility(GONE);
                mIndicator3.setVisibility(GONE);
                mIndicator4.setVisibility(GONE);
                mIndicator5.setVisibility(GONE);
                mIndicator6.setVisibility(GONE);
                mIndicator7.setVisibility(GONE);
                break;
            case 2:
                mIndicator1.setVisibility(GONE);
                mIndicator2.setVisibility(VISIBLE);
                mIndicator3.setVisibility(GONE);
                mIndicator4.setVisibility(GONE);
                mIndicator5.setVisibility(GONE);
                mIndicator6.setVisibility(GONE);
                mIndicator7.setVisibility(GONE);
                break;
            case 3:
                mIndicator1.setVisibility(GONE);
                mIndicator2.setVisibility(GONE);
                mIndicator3.setVisibility(VISIBLE);
                mIndicator4.setVisibility(GONE);
                mIndicator5.setVisibility(GONE);
                mIndicator6.setVisibility(GONE);
                mIndicator7.setVisibility(GONE);
                break;
            case 4:
                mIndicator1.setVisibility(GONE);
                mIndicator2.setVisibility(GONE);
                mIndicator3.setVisibility(GONE);
                mIndicator4.setVisibility(VISIBLE);
                mIndicator5.setVisibility(GONE);
                mIndicator6.setVisibility(GONE);
                mIndicator7.setVisibility(GONE);
                break;
            case 5:
                mIndicator1.setVisibility(GONE);
                mIndicator2.setVisibility(GONE);
                mIndicator3.setVisibility(GONE);
                mIndicator4.setVisibility(GONE);
                mIndicator5.setVisibility(VISIBLE);
                mIndicator6.setVisibility(GONE);
                mIndicator7.setVisibility(GONE);
                break;
            case 6:
                mIndicator1.setVisibility(GONE);
                mIndicator2.setVisibility(GONE);
                mIndicator3.setVisibility(GONE);
                mIndicator4.setVisibility(GONE);
                mIndicator5.setVisibility(GONE);
                mIndicator6.setVisibility(VISIBLE);
                mIndicator7.setVisibility(GONE);
                break;
            case 7:
                mIndicator1.setVisibility(GONE);
                mIndicator2.setVisibility(GONE);
                mIndicator3.setVisibility(GONE);
                mIndicator4.setVisibility(GONE);
                mIndicator5.setVisibility(GONE);
                mIndicator6.setVisibility(GONE);
                mIndicator7.setVisibility(VISIBLE);
                break;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        mViewPager = viewPager;
    }
}
