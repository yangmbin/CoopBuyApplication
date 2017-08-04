package com.coopbuy.mall.ui.mainpage.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.adapter.MainTabContentAdapter;
import com.coopbuy.mall.ui.mainpage.entity.TabEntity;
import com.coopbuy.mall.ui.mainpage.fragment.FourFragment;
import com.coopbuy.mall.ui.mainpage.fragment.OneFragment;
import com.coopbuy.mall.ui.mainpage.fragment.ThreeFragment;
import com.coopbuy.mall.ui.mainpage.fragment.TwoFragment;
import com.coopbuy.mall.ui.mainpage.model.MainModel;
import com.coopbuy.mall.ui.mainpage.presenter.MainPresenter;
import com.coopbuy.mall.ui.mainpage.view.Main_IView;
import com.coopbuy.mall.utils.ViewFindUtils;
import com.coopbuy.mall.widget.NoScrollViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements Main_IView {

    private String[] mTitles = {"首页", "分类", "便民", "个人中心"};
    private int[] mIconUnselectIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] mIconSelectIds = { R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private CommonTabLayout mTabLayout;
    private View mDecorView;

    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFmManager;

    @Bind(R.id.tab_content)
    NoScrollViewPager mViewPager;
    MainTabContentAdapter mContentAdapter;

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
        setCurrentTabView(0);
    }

    public void initBottomTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mDecorView = getWindow().getDecorView();
        mTabLayout = ViewFindUtils.find(mDecorView, R.id.tablayout);
        mTabLayout.setTabData(mTabEntities);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                setCurrentTabView(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    public void initFragment() {
        mFragments.add(new OneFragment());
        mFragments.add(new TwoFragment());
        mFragments.add(new ThreeFragment());
        mFragments.add(new FourFragment());
        mFmManager = getSupportFragmentManager();
    }

    public void initAdapter() {
        mContentAdapter = new MainTabContentAdapter(mFmManager, mFragments);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(mContentAdapter);
    }

    public void setCurrentTabView(int position) {
        mViewPager.setCurrentItem(position);
    }
}
