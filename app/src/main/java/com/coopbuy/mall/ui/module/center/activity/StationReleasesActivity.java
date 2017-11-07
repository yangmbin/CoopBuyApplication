package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.eventbus.CollectEvent;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.MainEvent;
import com.coopbuy.mall.eventbus.ReleaseEvent;
import com.coopbuy.mall.ui.module.center.adapter.StationsPagerAdapter;
import com.coopbuy.mall.ui.module.center.fragment.CollectFragment;
import com.coopbuy.mall.ui.module.center.fragment.ReleasesFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StationReleasesActivity extends BaseActivity {

    @Bind(R.id.top_rg_a)
    RadioButton mRbCollect;
    @Bind(R.id.top_rg_b)
    RadioButton mRbRelease;
    @Bind(R.id.main_top_rg)
    RadioGroup mainTopRg;
    @Bind(R.id.main_viewpager)
    ViewPager mainViewpager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_station_releases;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initEvent();
    }

    private void initEvent() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new CollectFragment());
        fragments.add(new ReleasesFragment());
        StationsPagerAdapter pagerAdapter = new StationsPagerAdapter(getSupportFragmentManager(), fragments);
        mainViewpager.setAdapter(pagerAdapter);
        mainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mRbCollect.setChecked(true);
                    EventBusInstance.getInstance().post(new CollectEvent());
                } else {
                    mRbRelease.setChecked(true);
                    EventBusInstance.getInstance().post(new ReleaseEvent());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mainTopRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mRbCollect.getId()) mainViewpager.setCurrentItem(0);
                else if (checkedId == mRbRelease.getId()) mainViewpager.setCurrentItem(1);
            }
        });

        //设置默认页
        mainViewpager.setCurrentItem(0);
    }

    @OnClick(R.id.titlebar_back)
    public void onViewClicked() {
        this.finish();
    }
}
