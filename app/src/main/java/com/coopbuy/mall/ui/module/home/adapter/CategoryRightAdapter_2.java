package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class CategoryRightAdapter_2 extends BaseDelegateAdapter<Object> {

    public CategoryRightAdapter_2(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_2_category_right;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {

    }
}
