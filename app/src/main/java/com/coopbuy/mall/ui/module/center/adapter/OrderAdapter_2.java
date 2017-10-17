package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.GetOrderListResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class OrderAdapter_2 extends BaseDelegateAdapter<GetOrderListResponse.ItemsBean.OrderItemBean> {

    private View.OnClickListener mListener;

    public OrderAdapter_2(Context ctx, List<GetOrderListResponse.ItemsBean.OrderItemBean> list, LayoutHelper mLayoutHelper, View.OnClickListener mListener) {
        super(ctx, list, mLayoutHelper);
        this.mListener = mListener;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_list_type_2;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final GetOrderListResponse.ItemsBean.OrderItemBean item) {
        /*((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Constant.IMAGE_SERVER_URL + item.getImageUrl());
        holder.getTextView(R.id.tv_goods_name).setText(item.getGoodsName());
        holder.getTextView(R.id.tv_quantity).setText("x" + item.getQuantity());
        holder.getTextView(R.id.tv_price).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
        holder.itemView.setOnClickListener(mListener);*/
    }
}
