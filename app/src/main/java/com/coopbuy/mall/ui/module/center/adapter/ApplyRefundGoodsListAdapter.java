package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class ApplyRefundGoodsListAdapter extends BaseRecyclerAdapter<Object> {

    public ApplyRefundGoodsListAdapter(Context ctx, List<Object> list) {
        super(ctx, list);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_goods_apply_refund;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
    }
}
