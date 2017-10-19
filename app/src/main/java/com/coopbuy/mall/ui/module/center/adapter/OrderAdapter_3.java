package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.coopbuy.mall.widget.popwindow.OrderMoreBtnPopwindow;

import java.util.List;

public class OrderAdapter_3 extends BaseDelegateAdapter<OrderListResponse.ItemsBeanX> implements View.OnClickListener {

    private View.OnClickListener mListener;

    public OrderAdapter_3(Context ctx, List<OrderListResponse.ItemsBeanX> list, LayoutHelper mLayoutHelper, View.OnClickListener mListener) {
        super(ctx, list, mLayoutHelper);
        this.mListener = mListener;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_list_type_3;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final OrderListResponse.ItemsBeanX item) {
        int totalQuantity = 0;
        for (int i = 0; i < item.getItems().size(); i++)
            totalQuantity += item.getItems().get(i).getQuantity();
        holder.getTextView(R.id.desc_left).setText("共" + totalQuantity + "件商品 合计：");
        holder.getTextView(R.id.desc_mid).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getTotalAmount()));
        holder.getTextView(R.id.desc_right).setText(" (含运费¥" + StringUtils.keepTwoDecimalPoint(item.getFreightAmount()) + ")");
        setBtnDisplay(holder, item);
        holder.itemView.setOnClickListener(mListener);
    }

    private void setBtnDisplay(BaseRecyclerHolder holder, OrderListResponse.ItemsBeanX item) {
        // 站长代付
        if (item.isCanApplyLieuPay())
            holder.getTextView(R.id.lieuPayBtn).setVisibility(View.VISIBLE);
        // 取消订单
        if (item.isCanCancel())
            holder.getTextView(R.id.cancelOrderBtn).setVisibility(View.VISIBLE);
        // 付款
        if (item.isCanPayment())
            holder.getTextView(R.id.payBtn).setVisibility(View.VISIBLE);
        // 延长收货
        if (item.isCanDelayedReceipt())
            holder.getTextView(R.id.delayedReceiptBtn).setVisibility(View.VISIBLE);
        // 查看物流
        if (item.isCanFindExpressInfo())
            holder.getTextView(R.id.findExpressInfoBtn).setVisibility(View.VISIBLE);
        // 确认收货
        if (item.isCanReceipt())
            holder.getTextView(R.id.receiptBtn).setVisibility(View.VISIBLE);
        // 删除订单
        if (item.isCanDelete())
            holder.getTextView(R.id.deleteBtn).setVisibility(View.VISIBLE);


        // 更多
        holder.getTextView(R.id.moreBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 更多
            case R.id.moreBtn:
                OrderMoreBtnPopwindow window = new OrderMoreBtnPopwindow(mContext, null);
                window.showWindow(v);
                break;
        }
    }
}
