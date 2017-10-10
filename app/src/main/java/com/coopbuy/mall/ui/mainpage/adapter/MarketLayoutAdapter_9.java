package com.coopbuy.mall.ui.mainpage.adapter;


import android.util.Log;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.fragment.MarketDayFragment;
import com.coopbuy.mall.widget.MarketPanicBuyingBar;

import java.util.List;

public class MarketLayoutAdapter_9 extends BaseDelegateAdapter<Object> {

    private MarketPanicBuyingBar buyingBar;
    private MarketDayFragment marketDayFragment;

    public MarketLayoutAdapter_9(MarketDayFragment fragment, List<Object> list, LayoutHelper mLayoutHelper) {
        super(fragment.getActivity(), list, mLayoutHelper);
        marketDayFragment = fragment;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_9_market;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
        buyingBar = (MarketPanicBuyingBar) holder.getView(R.id.buying_bar);
        buyingBar.setFragment(marketDayFragment);
        buyingBar.setIsFloatTab(true);
        buyingBar.selectTab(marketDayFragment.getCurrentTabIndex(), false);

        Log.e("yangmbin", "adapter9");
    }

    public void refreshTab() {
        buyingBar.selectTab(marketDayFragment.getCurrentTabIndex(), false);
        Log.e("yangmbin", "refreshTab:" + marketDayFragment.getCurrentTabIndex());
    }
}
