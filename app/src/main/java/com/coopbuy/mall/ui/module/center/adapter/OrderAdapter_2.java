package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class OrderAdapter_2 extends BaseDelegateAdapter<OrderListResponse.ItemsBeanX.ItemsBean> {

    private View.OnClickListener mListener;

    public OrderAdapter_2(Context ctx, List<OrderListResponse.ItemsBeanX.ItemsBean> list, LayoutHelper mLayoutHelper, View.OnClickListener mListener) {
        super(ctx, list, mLayoutHelper);
        this.mListener = mListener;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_list_type_2;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final OrderListResponse.ItemsBeanX.ItemsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(item.getProductImageUrl());
        holder.getTextView(R.id.tv_goods_name).setText(item.getProductName());
        holder.getTextView(R.id.tv_price).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
        holder.getTextView(R.id.propertyDesc).setText(item.getProperties() + " " + item.getSpecifications());
        holder.getTextView(R.id.tv_quantity).setText("x" + item.getQuantity());
        holder.getTextView(R.id.refundStatus).setText(item.getRefundStatus());
        holder.itemView.setOnClickListener(mListener);
    }
}
