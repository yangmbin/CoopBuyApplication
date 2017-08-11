package com.coopbuy.mall.ui.module.center.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.test.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.test.fragment.TestFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.Bind;

public class OrderActivity extends BaseActivity {

    @Bind(R.id.tablayout)
    SlidingTabLayout mTabLayout;
    @Bind(R.id.tab_content)
    ViewPager mViewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyViewPagerAdapter mAdapter;
    private final String[] mTitles = {"全部", "待付款", "待发货", "待收货", "待评价"};
//    private final String[] mTitles = {"热门", "iOS", "Android", "前端", "后端", "设计", "工具资源"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("TabLayout");
        initFragment();
        initAdapter();
    }

    private void initFragment() {
        for (int i = 0; i < 5; i++) {
            Fragment fragment = new TestFragment();
            mFragments.add(fragment);
        }
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mViewPager, mTitles, this, mFragments);
    }
}
