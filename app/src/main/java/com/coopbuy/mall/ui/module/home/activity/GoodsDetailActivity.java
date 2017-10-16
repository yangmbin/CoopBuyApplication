package com.coopbuy.mall.ui.module.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_1;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_2;
import com.coopbuy.mall.ui.module.home.model.GoodsDetailModel;
import com.coopbuy.mall.ui.module.home.presenter.GoodsDetailPresenter;
import com.coopbuy.mall.ui.module.home.view.GoodsDetail_IView;
import com.coopbuy.mall.widget.NavGoodsDetailBar;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * 商品详情
 *
 * @author ymb
 *         Create at 2017/8/10 13:59
 */
public class GoodsDetailActivity extends BaseActivity<GoodsDetailPresenter, GoodsDetailModel> implements GoodsDetail_IView {

    @Bind(R.id.topBar)
    NavGoodsDetailBar topBar;
    @Bind(R.id.tab_content)
    ViewPager mViewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyViewPagerAdapter mAdapter;
    private final String[] mTitles = {"商品", "详情"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    public void initModel() {
        mModel = new GoodsDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new GoodsDetailPresenter(mContext, mModel, this);
    }

    @Override
    public void initView() {
        initFragment();
        initAdapter();
    }

    private void initFragment() {
        mFragments.add(new GoodsDetailFragment_1());
        mFragments.add(new GoodsDetailFragment_2());
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        topBar.setViewPager(mViewPager, mTitles, this, mFragments);
    }

}
