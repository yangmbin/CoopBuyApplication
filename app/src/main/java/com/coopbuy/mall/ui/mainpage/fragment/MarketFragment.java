package com.coopbuy.mall.ui.mainpage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.MarketViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 赶场Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class MarketFragment extends ViewPagerBaseFragment {

    @Bind(R.id.tab_content)
    ViewPager tabContent;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_market;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        for (int i = 1; i <= 7; i++) {
            MarketDayFragment marketDayFragment = new MarketDayFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("dayNo", i);
            marketDayFragment.setArguments(bundle);
            fragmentList.add(marketDayFragment);
        }
        tabContent.setAdapter(new MarketViewPagerAdapter(getChildFragmentManager(), fragmentList));
        tabContent.setOffscreenPageLimit(3);
        tabContent.setCurrentItem(0); // 这里需要修改为当天
    }
}
