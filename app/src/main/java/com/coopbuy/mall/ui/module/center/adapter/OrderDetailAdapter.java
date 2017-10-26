package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class OrderDetailAdapter extends BaseRecyclerAdapter<OrderDetailResponse.OrderItemsBean> {

    public OrderDetailAdapter(Context ctx, List<OrderDetailResponse.OrderItemsBean> list) {
        super(ctx, list);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_detail_goods;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final OrderDetailResponse.OrderItemsBean item) {
        // 商品信息
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(item.getProductImageUrl());
        holder.getTextView(R.id.tv_goods_name).setText(item.getProductName());
        holder.getTextView(R.id.tv_quantity).setText("x" + item.getQuantity());
        holder.getTextView(R.id.tv_price).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
        holder.getTextView(R.id.propertyDesc).setText(item.getSpecifications() + " " + item.getProperties());
        // 退款状态
        holder.getTextView(R.id.refundStatus).setText(item.getRefundStatus());
        // 退款按钮
        if (item.isCanApplyRefund()) {
            holder.getTextView(R.id.applyRefundBtn).setVisibility(View.VISIBLE);
            holder.getTextView(R.id.applyRefundBtn).setText(item.getApplyRefundButtonText());
        }


    }
}
