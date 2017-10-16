package com.coopbuy.mall.ui.module.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.home.fragment.ShopDetailFragment_1;
import com.coopbuy.mall.ui.module.home.fragment.ShopDetailFragment_2;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 店铺详情
 *
 * @author ymb
 *         Create at 2017/8/10 13:59
 */
public class ShopDetailActivity extends BaseActivity {

    @Bind(R.id.tab_content)
    ViewPager mViewPager;
    @Bind(R.id.tab_1_image)
    ImageView tab1Image;
    @Bind(R.id.tab_1_text)
    TextView tab1Text;
    @Bind(R.id.tab_2_num)
    TextView tab2Num;
    @Bind(R.id.tab_2_text)
    TextView tab2Text;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyViewPagerAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_detail;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("XXX店");
        setRightImage(R.mipmap.icon_nav_home_top_cart);
        initFragment();
        initAdapter();
    }

    private void initFragment() {
        mFragments.add(new ShopDetailFragment_1());
        mFragments.add(new ShopDetailFragment_2());
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
    }

    @OnClick({R.id.tab_1, R.id.tab_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tab_1:
                switchTab(0);
                break;
            case R.id.tab_2:
                switchTab(1);
                break;
        }
    }

    /**
     * 标签切换
     *
     * @param tabIndex
     */
    private void switchTab(int tabIndex) {
        mViewPager.setCurrentItem(tabIndex);
        if (tabIndex == 0) {
            tab1Image.setImageResource(R.mipmap.icon_shop_detail_mainpage_light);
            tab1Text.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
            tab2Num.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
            tab2Text.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
        } else {
            tab1Image.setImageResource(R.mipmap.icon_shop_detail_mainpage_dark);
            tab1Text.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
            tab2Num.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
            tab2Text.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
        }
    }

    /**
     * 动态设置ViewPager高度
     * @param height
     */
    public void setViewPagerHeight(int height) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mViewPager.getLayoutParams();
        params.height = height;
        mViewPager.setLayoutParams(params);
    }

}
