package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.request.BeforeApplyRefundRequest;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.center.activity.ApplyRefundActivity;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class OrderDetailAdapter extends BaseRecyclerAdapter<OrderDetailResponse.OrderItemsBean> {

    private String orderId;
    private int orderType;

    public OrderDetailAdapter(Context ctx, List<OrderDetailResponse.OrderItemsBean> list, String orderId) {
        super(ctx, list);
        this.orderId = orderId;
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
        holder.getTextView(R.id.tv_price).setText("￥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
        holder.getTextView(R.id.propertyDesc).setText(item.getSpecifications() + " " + item.getProperties());
        // 退款状态
        holder.getTextView(R.id.refundStatus).setText(item.getRefundStatus());
        // 退款按钮
        if (item.isCanApplyRefund()) {
            holder.getTextView(R.id.applyRefundBtn).setVisibility(View.VISIBLE);
            holder.getTextView(R.id.applyRefundBtn).setText(item.getApplyRefundButtonText());
        }

        // 申请退款（单品退）
        holder.getTextView(R.id.applyRefundBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeforeApplyRefundRequest request = new BeforeApplyRefundRequest();
                request.setSkuId(item.getSkuId());
                request.setOrderId(orderId);
                IntentUtils.gotoActivity(mContext, ApplyRefundActivity.class, request);
            }
        });

        // 点击监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 普通商品能查看详情，话费商品不可以
                if (orderType == 1)
                    IntentUtils.gotoActivity(mContext, GoodsDetailActivity.class, item.getSkuId());
            }
        });
    }

    /**
     * 设置订单类型
     * @param orderType
     */
    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }
}
