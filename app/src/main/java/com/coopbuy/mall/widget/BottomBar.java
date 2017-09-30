package com.coopbuy.mall.widget;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.ui.mainpage.adapter.MainTabContentAdapter;
import com.coopbuy.mall.ui.mainpage.fragment.HomeFragment;
import com.coopbuy.mall.ui.mainpage.fragment.MarketFragment;
import com.coopbuy.mall.ui.mainpage.fragment.ThreeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * BottomBar
 *
 * @author ymb
 *         Create at 2017/8/18 15:05
 */
public class BottomBar extends RelativeLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;
    private LinearLayout mTab1, mTab2, mTab3;
    private TextView mTvTab1, mTvTab2, mTvTab3;
    private ImageView mIvTab1, mIvTab2, mIvTab3;
    private NoScrollViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFmManager;
    private MainTabContentAdapter mContentAdapter;

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

        mIvTab1 = (ImageView) mView.findViewById(R.id.tab_1_icon);
        mIvTab2 = (ImageView) mView.findViewById(R.id.tab_2_icon);
        mIvTab3 = (ImageView) mView.findViewById(R.id.tab_3_icon);

        mViewPager = (NoScrollViewPager) mView.findViewById(R.id.tab_content);

        init();
    }

    private void init() {
        initFragment();
        initAdapter();
        initBottomTab();
        setCurrentView(0);
    }

    public void initFragment() {
        mFragments.add(new HomeFragment());
        mFragments.add(new MarketFragment());
        mFragments.add(new ThreeFragment());
        mFmManager = ((MainActivity) mContext).getSupportFragmentManager();
    }

    public void initAdapter() {
        mContentAdapter = new MainTabContentAdapter(mFmManager, mFragments);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mContentAdapter);
    }

    public void initBottomTab() {
        setViewPager(mViewPager);
    }

    public void setCurrentView(int position) {
        mViewPager.setCurrentItem(position);
        setCurrentTab(position);
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

    public void setViewPager(NoScrollViewPager viewPager) {
        this.mViewPager = viewPager;
        mTab1.setOnClickListener(this);
        mTab2.setOnClickListener(this);
        mTab3.setOnClickListener(this);
    }

    public void setCurrentTab(int position) {
        if (position == 0)
            setTab1();
        else if (position == 1)
            setTab2();
        else if (position == 2)
            setTab3();
    }

    private void setTab1() {
        mTvTab1.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
        mTvTab2.setTextColor(ContextCompat.getColor(mContext, R.color.auxiliary_text_blue_gray));
        mTvTab3.setTextColor(ContextCompat.getColor(mContext, R.color.auxiliary_text_blue_gray));
        mIvTab1.setImageResource(R.mipmap.icon_home_selected);
        mIvTab2.setImageResource(R.mipmap.icon_market_unselected);
        mIvTab3.setImageResource(R.mipmap.icon_center_unselected);
        mViewPager.setCurrentItem(0);
    }

    private void setTab2() {
        mTvTab1.setTextColor(ContextCompat.getColor(mContext, R.color.auxiliary_text_blue_gray));
        mTvTab2.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
        mTvTab3.setTextColor(ContextCompat.getColor(mContext, R.color.auxiliary_text_blue_gray));
        mIvTab1.setImageResource(R.mipmap.icon_home_unselected);
        mIvTab2.setImageResource(R.mipmap.icon_market_selected);
        mIvTab3.setImageResource(R.mipmap.icon_center_unselected);
        mViewPager.setCurrentItem(1);
    }

    private void setTab3() {
        mTvTab1.setTextColor(ContextCompat.getColor(mContext, R.color.auxiliary_text_blue_gray));
        mTvTab2.setTextColor(ContextCompat.getColor(mContext, R.color.auxiliary_text_blue_gray));
        mTvTab3.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
        mIvTab1.setImageResource(R.mipmap.icon_home_unselected);
        mIvTab2.setImageResource(R.mipmap.icon_market_unselected);
        mIvTab3.setImageResource(R.mipmap.icon_center_selected);
        mViewPager.setCurrentItem(2);
    }
}
