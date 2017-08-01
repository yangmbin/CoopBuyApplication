package com.coopbuy.mall.ui.mainpage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 主页ViewPager适配器
 * @author ymb
 * Create at 2017/7/25 14:01
 */
public class MainTabContentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public MainTabContentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
