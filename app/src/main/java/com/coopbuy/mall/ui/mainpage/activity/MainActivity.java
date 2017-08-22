package com.coopbuy.mall.ui.mainpage.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.adapter.MainTabContentAdapter;
import com.coopbuy.mall.ui.mainpage.fragment.OneFragment;
import com.coopbuy.mall.ui.mainpage.fragment.ThreeFragment;
import com.coopbuy.mall.ui.mainpage.fragment.TwoFragment;
import com.coopbuy.mall.ui.mainpage.model.MainModel;
import com.coopbuy.mall.ui.mainpage.presenter.MainPresenter;
import com.coopbuy.mall.ui.mainpage.view.Main_IView;
import com.coopbuy.mall.widget.BottomBar;
import com.coopbuy.mall.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements Main_IView {

    @Bind(R.id.tab_content)
    NoScrollViewPager mViewPager;
    @Bind(R.id.bottom_bar)
    BottomBar mBottomBar;

    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFmManager;
    private MainTabContentAdapter mContentAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initModel() {
        mModel = new MainModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new MainPresenter(mContext, mModel, this);
    }

    @Override
    public void initView() {
        initFragment();
        initAdapter();
        initBottomTab();
        setCurrentView(0);
    }

    public void initBottomTab() {
        mBottomBar.setViewPager(mViewPager);
    }

    public void initFragment() {
        mFragments.add(new OneFragment());
        mFragments.add(new TwoFragment());
        mFragments.add(new ThreeFragment());
        mFmManager = getSupportFragmentManager();
    }

    public void initAdapter() {
        mContentAdapter = new MainTabContentAdapter(mFmManager, mFragments);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mContentAdapter);
    }

    public void setCurrentView(int position) {
        mViewPager.setCurrentItem(position);
        mBottomBar.setCurrentTab(position);
    }
}
