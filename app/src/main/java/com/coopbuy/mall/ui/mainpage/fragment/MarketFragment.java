package com.coopbuy.mall.ui.mainpage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.MarketViewPagerAdapter;
import com.coopbuy.mall.widget.MarketWeekBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 赶场Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class MarketFragment extends ViewPagerBaseFragment implements ViewPager.OnPageChangeListener {

    @Bind(R.id.tab_content)
    ViewPager tabContent;
    @Bind(R.id.week_bar)
    MarketWeekBar weekBar;
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


        weekBar.setIndicatorPosition(1);
        weekBar.setViewPager(tabContent);

        // 设置Viewpager滑动监听
        tabContent.addOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.e("yangmbin", "position:" + position);
        weekBar.setIndicatorPosition(position + 1);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
