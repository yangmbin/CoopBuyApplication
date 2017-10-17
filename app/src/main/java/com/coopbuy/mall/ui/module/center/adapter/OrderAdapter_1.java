package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class OrderAdapter_1 extends BaseDelegateAdapter<OrderListResponse.ItemsBeanX> {

    private View.OnClickListener mListener;

    public OrderAdapter_1(Context ctx, List<OrderListResponse.ItemsBeanX> list, LayoutHelper mLayoutHelper, View.OnClickListener mListener) {
        super(ctx, list, mLayoutHelper);
        this.mListener = mListener;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_list_type_1;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final OrderListResponse.ItemsBeanX item) {
        holder.getTextView(R.id.tv_shop_name).setText(item.getShopName());
        holder.getTextView(R.id.tv_status).setText(item.getStatusName());
        holder.itemView.setOnClickListener(mListener);
    }
}
