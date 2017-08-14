package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.login.OrderDetailResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class OrderDetailAdapter extends BaseDelegateAdapter<OrderDetailResponse.OrderItemBean> {

    public OrderDetailAdapter(Context ctx, List<OrderDetailResponse.OrderItemBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_detail_goods_list;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final OrderDetailResponse.OrderItemBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Constant.IMAGE_SERVER_URL + item.getImageUrl());
        holder.getTextView(R.id.tv_goods_name).setText(item.getGoodsName());
        holder.getTextView(R.id.tv_quantity).setText("x" + item.getQuantity());
        holder.getTextView(R.id.tv_price).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
    }
}
