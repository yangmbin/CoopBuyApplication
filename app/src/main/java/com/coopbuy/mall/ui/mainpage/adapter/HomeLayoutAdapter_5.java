package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class HomeLayoutAdapter_5 extends BaseDelegateAdapter<HomePageDataResponse.FloorsBean> {

    public HomeLayoutAdapter_5(Context ctx, List<HomePageDataResponse.FloorsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_5_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final HomePageDataResponse.FloorsBean item) {

    }
}
