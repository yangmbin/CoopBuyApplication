package com.coopbuy.mall.ui.module.center.adapter;


import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.api.request.AddToCartRequest;
import com.coopbuy.mall.api.request.BeforeApplyRefundRequest;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.bean.PayAgainParams;
import com.coopbuy.mall.ui.module.center.activity.ApplyRefundActivity;
import com.coopbuy.mall.ui.module.center.activity.ExpressInfoActivity;
import com.coopbuy.mall.ui.module.center.pay.PayFailActivity;
import com.coopbuy.mall.ui.module.center.presenter.OrderPresenter;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.StringUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;
import com.coopbuy.mall.widget.popwindow.OrderMoreBtnPopwindow;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter_3 extends BaseDelegateAdapter<OrderListResponse.ItemsBeanX> implements View.OnClickListener {

    private View.OnClickListener mListener;
    private OrderPresenter mOrderPresenter;
    private OrderListResponse.ItemsBeanX mItemOrder;

    public OrderAdapter_3(Context ctx, OrderPresenter presenter, List<OrderListResponse.ItemsBeanX> list, LayoutHelper mLayoutHelper, View.OnClickListener mListener) {
        super(ctx, list, mLayoutHelper);
        this.mListener = mListener;
        this.mOrderPresenter = presenter;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_list_type_3;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final OrderListResponse.ItemsBeanX item) {
        mItemOrder = item;
        int totalQuantity = 0;
        for (int i = 0; i < item.getItems().size(); i++)
            totalQuantity += item.getItems().get(i).getQuantity();
        holder.getTextView(R.id.desc_left).setText("共" + totalQuantity + "件商品 合计：");
        holder.getTextView(R.id.desc_mid).setText("￥" + StringUtils.keepTwoDecimalPoint(item.getTotalAmount()));
        holder.getTextView(R.id.desc_right).setText(" (含运费￥" + StringUtils.keepTwoDecimalPoint(item.getFreightAmount()) + ")");
        setBtnDisplay(holder, item);
        holder.itemView.setOnClickListener(mListener);
    }

    private void setBtnDisplay(BaseRecyclerHolder holder, OrderListResponse.ItemsBeanX item) {
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
        // 再来一单
        if (item.isCanRepeatSubmitOrder())
            holder.getTextView(R.id.repeatSubmitOrderBtn).setVisibility(View.VISIBLE);
        // 提醒商家发货
        if (item.isCanRemindShipment())
            holder.getTextView(R.id.remindShipmentBtn).setVisibility(View.VISIBLE);
        // 申请退款/售后
        if (item.isCanApplyRefund()) {
            holder.getTextView(R.id.applyRefundBtn).setVisibility(View.VISIBLE);
            holder.getTextView(R.id.applyRefundBtn).setText(item.getApplyRefundButtonText());
        }


        // 更多（删除订单、申请退款/售后）
        if (item.isCanDelete() && item.isCanApplyRefund()) {
            holder.getTextView(R.id.deleteBtn).setVisibility(View.GONE);
            holder.getTextView(R.id.applyRefundBtn).setVisibility(View.GONE);
            holder.getTextView(R.id.moreBtn).setVisibility(View.VISIBLE);
        }

        // 设置监听
        holder.getTextView(R.id.cancelOrderBtn).setOnClickListener(this);
        holder.getTextView(R.id.payBtn).setOnClickListener(this);
        holder.getTextView(R.id.delayedReceiptBtn).setOnClickListener(this);
        holder.getTextView(R.id.findExpressInfoBtn).setOnClickListener(this);
        holder.getTextView(R.id.receiptBtn).setOnClickListener(this);
        holder.getTextView(R.id.deleteBtn).setOnClickListener(this);
        holder.getTextView(R.id.repeatSubmitOrderBtn).setOnClickListener(this);
        holder.getTextView(R.id.remindShipmentBtn).setOnClickListener(this);
        holder.getTextView(R.id.applyRefundBtn).setOnClickListener(this);
        holder.getTextView(R.id.moreBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 取消订单
            case R.id.cancelOrderBtn:
                cancelOrderBtn();
                break;
            // 付款
            case R.id.payBtn:
                payBtn();
                break;
            // 延长收货
            case R.id.delayedReceiptBtn:
                delayedReceiptBtn();
                break;
            // 查看物流
            case R.id.findExpressInfoBtn:
                findExpressInfoBtn();
                break;
            // 确认收货
            case R.id.receiptBtn:
                receiptBtn();
                break;
            // 删除订单
            case R.id.deleteBtn:
                deleteBtn();
                break;
            // 再来一单
            case R.id.repeatSubmitOrderBtn:
                repeatSubmitOrderBtn();
                break;
            // 提醒商家发货
            case R.id.remindShipmentBtn:
                remindShipmentBtn();
                break;
            // 申请退款/售后
            case R.id.applyRefundBtn:
                applyRefundBtn();
                break;
            // 更多
            case R.id.moreBtn:
                OrderMoreBtnPopwindow window = new OrderMoreBtnPopwindow(mContext, null, this);
                window.showWindow(v);
                break;
        }
    }

    /**
     * 取消订单
     */
    private void cancelOrderBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mOrderPresenter.cancelOrder(mItemOrder.getOrderId());
            }
        }, "是否确定取消订单？", "取消", "确定");
    }

    /**
     * 付款
     */
    private void payBtn() {
        PayAgainParams params = new PayAgainParams();
        int count = 0;
        for (int i = 0; i < mItemOrder.getItems().size(); i++)
            count += mItemOrder.getItems().get(i).getQuantity();
        params.setmCountsTotal(count + "");
        params.setmCountsTotalPrice((mItemOrder.getTotalAmount() + mItemOrder.getFreightAmount()) + "");
        params.setmWaitOrderId(mItemOrder.getOrderId());
        params.setPalyListType(mItemOrder.getOrderType());
        PayFailActivity.gotoActivity((Activity) mContext, params);
    }

    /**
     * 申请退款/售后（整单退）
     */
    public void applyRefundBtn() {
        BeforeApplyRefundRequest request = new BeforeApplyRefundRequest();
        request.setSkuId(-1);
        request.setOrderId(mItemOrder.getOrderId());
        IntentUtils.gotoActivity(mContext, ApplyRefundActivity.class, request);
    }

    /**
     * 提醒商家发货
     */
    private void remindShipmentBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mOrderPresenter.remindShipment(mItemOrder.getOrderId());
            }
        }, "是否提醒商家发货？", "取消", "确定");
    }

    /**
     * 延长收货
     */
    private void delayedReceiptBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mOrderPresenter.delayedReceipt(mItemOrder.getOrderId());
            }
        }, "是否延迟签收订单？", "取消", "确定");
    }

    /**
     * 删除订单
     */
    public void deleteBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mOrderPresenter.deleteOrder(mItemOrder.getOrderId());
            }
        }, "是否确定删除订单？", "取消", "确定");
    }

    /**
     * 查看物流
     */
    private void findExpressInfoBtn() {
        IntentUtils.gotoActivity(mContext, ExpressInfoActivity.class, mItemOrder.getOrderId());
    }

    /**
     * 确认收货
     */
    private void receiptBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mOrderPresenter.receipt(mItemOrder.getOrderId());
            }
        }, "是否确认收货？", "取消", "确定");
    }

    /**
     * 再来一单
     */
    private void repeatSubmitOrderBtn() {
        AddToCartRequest request = new AddToCartRequest();
        List<AddToCartRequest.SkusBean> skusBeanList = new ArrayList<>();
        for (int i = 0; i < mItemOrder.getItems().size(); i++) {
            AddToCartRequest.SkusBean skusBean = new AddToCartRequest.SkusBean();
            skusBean.setSkuId(mItemOrder.getItems().get(i).getSkuId());
            skusBean.setQuantity(mItemOrder.getItems().get(i).getQuantity());
            skusBeanList.add(skusBean);
        }
        request.setSkus(skusBeanList);

        mOrderPresenter.repeatSubmitOrder(request);
    }
}
