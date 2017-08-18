package com.coopbuy.mall.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;

/**
 * BottomBar
 * @author ymb
 * Create at 2017/8/18 15:05
 */
public class BottomBar extends RelativeLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;
    private LinearLayout mTab1, mTab2, mTab3;
    private TextView mTvTab1, mTvTab2, mTvTab3;
    private ViewPager mViewPager;

    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.bottom_bar, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        mTab1 = (LinearLayout) mView.findViewById(R.id.tab_1);
        mTab2 = (LinearLayout) mView.findViewById(R.id.tab_2);
        mTab3 = (LinearLayout) mView.findViewById(R.id.tab_3);

        mTvTab1 = (TextView) mView.findViewById(R.id.tab_1_text);
        mTvTab2 = (TextView) mView.findViewById(R.id.tab_2_text);
        mTvTab3 = (TextView) mView.findViewById(R.id.tab_3_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_1:
                setTab1();
                break;
            case R.id.tab_2:
                setTab2();
                break;
            case R.id.tab_3:
                setTab3();
                break;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        mTab1.setOnClickListener(this);
        mTab2.setOnClickListener(this);
        mTab3.setOnClickListener(this);
    }

    public void setCurrentTab(int position) {
        if (position == 0) {
            setTab1();
        } else if (position == 1) {
            setTab2();
        } else if (position == 2) {
            setTab3();
        }
    }

    private void setTab1() {
        mTvTab1.setTextColor(ContextCompat.getColor(mContext, R.color.green));
        mTvTab2.setTextColor(ContextCompat.getColor(mContext, R.color.gray_2));
        mTvTab3.setTextColor(ContextCompat.getColor(mContext, R.color.gray_2));
        mViewPager.setCurrentItem(0);
    }

    private void setTab2() {
        mTvTab1.setTextColor(ContextCompat.getColor(mContext, R.color.gray_2));
        mTvTab2.setTextColor(ContextCompat.getColor(mContext, R.color.green));
        mTvTab3.setTextColor(ContextCompat.getColor(mContext, R.color.gray_2));
        mViewPager.setCurrentItem(1);
    }

    private void setTab3() {
        mTvTab1.setTextColor(ContextCompat.getColor(mContext, R.color.gray_2));
        mTvTab2.setTextColor(ContextCompat.getColor(mContext, R.color.gray_2));
        mTvTab3.setTextColor(ContextCompat.getColor(mContext, R.color.green));
        mViewPager.setCurrentItem(2);
    }
}
