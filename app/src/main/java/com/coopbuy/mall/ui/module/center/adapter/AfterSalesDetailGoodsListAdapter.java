package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/19 11:39
 */
public class AfterSalesDetailGoodsListAdapter extends BaseRecyclerAdapter<Object> {

    public AfterSalesDetailGoodsListAdapter(Context ctx, List<Object> list) {
        super(ctx, list);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_after_sales_detail_goods_list;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, Object item) {

    }
}
