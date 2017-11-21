package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class HomeLayoutAdapter_4 extends BaseDelegateAdapter<Object> {

    private List<Object> floors;

    public HomeLayoutAdapter_4(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        this.floors = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_4_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
    }
}
