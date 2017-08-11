package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.login.GetOrderListResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class OrderGoodsAdapter extends BaseDelegateAdapter<GetOrderListResponse.ItemsBean.OrderItemBean> {

    public OrderGoodsAdapter(Context ctx, List<GetOrderListResponse.ItemsBean.OrderItemBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_list_goods;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final GetOrderListResponse.ItemsBean.OrderItemBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Constant.IMAGE_SERVER_URL + item.getImageUrl());
        holder.getTextView(R.id.tv_goods_name).setText(item.getGoodsName());
        holder.getTextView(R.id.tv_quantity).setText("x" + item.getQuantity());
        holder.getTextView(R.id.tv_price).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
    }
}
