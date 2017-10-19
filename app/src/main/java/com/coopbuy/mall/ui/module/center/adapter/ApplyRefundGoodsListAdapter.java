package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class ApplyRefundGoodsListAdapter extends BaseDelegateAdapter<Object> {

    public ApplyRefundGoodsListAdapter(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_goods_apply_refund;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
    }
}
