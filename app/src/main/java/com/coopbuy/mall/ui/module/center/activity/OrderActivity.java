package com.coopbuy.mall.ui.module.center.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.center.fragment.AllOrderFragment;
import com.coopbuy.mall.ui.module.center.fragment.WaitCommentOrderFragment;
import com.coopbuy.mall.ui.module.center.fragment.WaitPayOrderFragment;
import com.coopbuy.mall.ui.module.center.fragment.WaitReceiveOrderFragment;
import com.coopbuy.mall.ui.module.center.fragment.WaitSendOrderFragment;
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
        setTitle("订单列表");
        initFragment();
        initAdapter();
    }

    private void initFragment() {
        mFragments.add(new AllOrderFragment());
        mFragments.add(new WaitPayOrderFragment());
        mFragments.add(new WaitSendOrderFragment());
        mFragments.add(new WaitReceiveOrderFragment());
        mFragments.add(new WaitCommentOrderFragment());
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mViewPager, mTitles, this, mFragments);
    }
}
