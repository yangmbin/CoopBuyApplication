package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class MarketLayoutAdapter_8 extends BaseDelegateAdapter<Object> {

    public MarketLayoutAdapter_8(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_8_market;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
    }
}
