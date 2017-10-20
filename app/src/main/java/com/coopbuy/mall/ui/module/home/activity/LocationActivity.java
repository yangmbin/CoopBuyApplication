package com.coopbuy.mall.ui.module.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.home.fragment.LocationFragment;
import com.coopbuy.mall.widget.navigation.NavSearchBar;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.Bind;


public class LocationActivity extends BaseActivity {
    @Bind(R.id.navSearchBar)
    NavSearchBar navSearchBar;
    @Bind(R.id.tablayout)
    SlidingTabLayout mTabLayout;
    @Bind(R.id.tab_content)
    ViewPager mViewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyViewPagerAdapter mAdapter;
    private final String[] mTitles = {"省内", "全国"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_location;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        navSearchBar.setHint("城市名/拼音");
        initFragment();
        initAdapter();
    }

    private void initFragment() {
        mFragments.add(new LocationFragment());
        mFragments.add(new LocationFragment());
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mViewPager, mTitles, this, mFragments);
    }
}
