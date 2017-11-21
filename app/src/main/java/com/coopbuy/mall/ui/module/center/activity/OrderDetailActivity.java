package com.coopbuy.mall.ui.module.center.activity;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.request.AddToCartRequest;
import com.coopbuy.mall.api.request.BeforeApplyRefundRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.bean.PayAgainParams;
import com.coopbuy.mall.ui.module.center.adapter.OrderDetailAdapter;
import com.coopbuy.mall.ui.module.center.model.OrderDetailModel;
import com.coopbuy.mall.ui.module.center.pay.PayFailActivity;
import com.coopbuy.mall.ui.module.center.presenter.OrderDetailPresenter;
import com.coopbuy.mall.ui.module.center.view.OrderDetail_IView;
import com.coopbuy.mall.ui.module.home.activity.ShopDetailActivity;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.StringUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter, OrderDetailModel> implements OrderDetail_IView {
    @Bind(R.id.rv_goods_list)
    RecyclerView mRvGoodsList;
    @Bind(R.id.expressLayout)
    LinearLayout expressLayout;
    @Bind(R.id.expressInfo)
    TextView expressInfo;
    @Bind(R.id.expressTime)
    TextView expressTime;
    @Bind(R.id.consignerName)
    TextView consignerName;
    @Bind(R.id.consignerTel)
    TextView consignerTel;
    @Bind(R.id.consignerAddress)
    TextView consignerAddress;
    @Bind(R.id.shopName)
    TextView shopName;
    @Bind(R.id.freightAmount)
    TextView freightAmount;
    @Bind(R.id.remark)
    TextView remark;
    @Bind(R.id.totalAmount)
    TextView totalAmount;
    @Bind(R.id.orderAmount)
    TextView orderAmount;
    @Bind(R.id.orderId)
    TextView orderId;
    @Bind(R.id.createTime)
    TextView createTime;
    @Bind(R.id.payTime)
    TextView payTime;
    @Bind(R.id.finishTime)
    TextView finishTime;
    @Bind(R.id.cancelOrderBtn)
    TextView cancelOrderBtn;
    @Bind(R.id.payBtn)
    TextView payBtn;
    @Bind(R.id.applyRefundBtn)
    TextView applyRefundBtn;
    @Bind(R.id.remindShipmentBtn)
    TextView remindShipmentBtn;
    @Bind(R.id.delayedReceiptBtn)
    TextView delayedReceiptBtn;
    @Bind(R.id.deleteBtn)
    TextView deleteBtn;
    @Bind(R.id.findExpressInfoBtn)
    TextView findExpressInfoBtn;
    @Bind(R.id.receiptBtn)
    TextView receiptBtn;
    @Bind(R.id.repeatSubmitOrderBtn)
    TextView repeatSubmitOrderBtn;
    @Bind(R.id.top_status)
    TextView topStatus;
    @Bind(R.id.top_desc)
    TextView topDesc;
    @Bind(R.id.status_bg)
    LinearLayout statusBg;
    private OrderDetailAdapter mOrderDetailAdapter;
    private List<OrderDetailResponse.OrderItemsBean> mDatas = new ArrayList<>();
    private OrderDetailResponse mOrderDetailResponse;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void initModel() {
        mModel = new OrderDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new OrderDetailPresenter(mContext, mModel, this);
        getOrderDetail();
    }

    @Override
    public void initView() {
        setTitle("订单详情");
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setAutoMeasureEnabled(true);
        mRvGoodsList.setLayoutManager(manager);
        mOrderDetailAdapter = new OrderDetailAdapter(mContext, mDatas, getIntent().getStringExtra(IntentUtils.PARAM1));
        mRvGoodsList.setAdapter(mOrderDetailAdapter);
    }

    private void getOrderDetail() {
        if (getIntent().getStringExtra(IntentUtils.PARAM1) == null)
            return;
        String orderId = getIntent().getStringExtra(IntentUtils.PARAM1);
        mPresenter.getOrderDetail(orderId);
    }

    @Override
    protected void networkRetry() {
        getOrderDetail();
    }

    @Override
    public void setOrderDetailData(OrderDetailResponse orderDetailResponse) {
        if (orderDetailResponse == null)
            return;

        // 保存返回信息
        mOrderDetailResponse = orderDetailResponse;

        // 设置顶部状态信息（1-待支付，2-待发货，3-待收货，4-已完成，5-已取消，6-已关闭）
        if (orderDetailResponse.isApplyLieuPay()) {
            statusBg.setBackgroundResource(R.mipmap.bg_order_station_pay);
        } else {
            if (orderDetailResponse.getOrderStatus() == 1) {
                statusBg.setBackgroundResource(R.mipmap.bg_order_wait_pay);
            } else if (orderDetailResponse.getOrderStatus() == 2) {
                statusBg.setBackgroundResource(R.mipmap.bg_order_wait_send);
            } else if (orderDetailResponse.getOrderStatus() == 3) {
                statusBg.setBackgroundResource(R.mipmap.bg_order_wait_receive);
            } else if (orderDetailResponse.getOrderStatus() == 4) {
                statusBg.setBackgroundResource(R.mipmap.bg_order_completed);
            } else if (orderDetailResponse.getOrderStatus() == 5 || orderDetailResponse.getOrderStatus() == 6) {
                statusBg.setBackgroundResource(R.mipmap.bg_order_closed);
            }
        }


        // 设置商品列表
        mDatas.clear();
        mDatas.addAll(orderDetailResponse.getOrderItems());
        mOrderDetailAdapter.setOrderType(orderDetailResponse.getOrderType());
        mOrderDetailAdapter.notifyDataSetChanged();

        // 物流信息
        if (orderDetailResponse.getCargoInfo() != null) {
            expressLayout.setVisibility(View.VISIBLE);
            expressInfo.setText(orderDetailResponse.getCargoInfo().getText());
            expressInfo.setText(orderDetailResponse.getCargoInfo().getTime());
        }

        // 收货人信息
        consignerName.setText(orderDetailResponse.getConsignerName());
        consignerTel.setText(orderDetailResponse.getConsignerTel());
        consignerAddress.setText(orderDetailResponse.getRegionName() + orderDetailResponse.getConsignerAddress());

        // 店铺名
        shopName.setText(orderDetailResponse.getShopName());
        // 运费
        freightAmount.setText("¥" + StringUtils.keepTwoDecimalPoint(orderDetailResponse.getFreightAmount()));
        // 买家留言
        remark.setText(TextUtils.isEmpty(orderDetailResponse.getRemark()) ? "无" : orderDetailResponse.getRemark());
        // 订单总价
        totalAmount.setText("¥" + StringUtils.keepTwoDecimalPoint(orderDetailResponse.getTotalAmount()));
        // 实付款
        orderAmount.setText("¥" + StringUtils.keepTwoDecimalPoint(orderDetailResponse.getOrderAmount()));

        // 订单编号
        orderId.setText("订单编号：" + orderDetailResponse.getOrderId());
        // 创建时间
        if (!TextUtils.isEmpty(orderDetailResponse.getCreateTime())) {
            createTime.setText("创建时间：" + orderDetailResponse.getCreateTime());
            createTime.setVisibility(View.VISIBLE);
        }
        // 付款时间
        if (!TextUtils.isEmpty(orderDetailResponse.getPaymentTime())) {
            payTime.setText("付款时间：" + orderDetailResponse.getPaymentTime());
            payTime.setVisibility(View.VISIBLE);
        }
        // 完成时间
        if (!TextUtils.isEmpty(orderDetailResponse.getFinishTime())) {
            finishTime.setText("完成时间：" + orderDetailResponse.getFinishTime());
            finishTime.setVisibility(View.VISIBLE);
        }

        // 设置按钮显示
        setBtnDisplay(orderDetailResponse);
    }

    /**
     * 点击事件监听
     *
     * @param view
     */
    @OnClick({R.id.contact_service, R.id.dial_phone, R.id.copy, R.id.cancelOrderBtn, R.id.payBtn, R.id.applyRefundBtn, R.id.remindShipmentBtn, R.id.delayedReceiptBtn, R.id.deleteBtn, R.id.findExpressInfoBtn, R.id.receiptBtn, R.id.repeatSubmitOrderBtn, R.id.shop_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 跳转店铺
            case R.id.shop_btn:
                IntentUtils.gotoActivity(mContext, ShopDetailActivity.class, mOrderDetailResponse.getShopId());
                break;
            // 联系客服
            case R.id.contact_service:
                ToastUtils.toastShort("联系客服");
                break;
            // 拨打商家电话
            case R.id.dial_phone:
                DialogUtils.showDialDialog(mContext, mOrderDetailResponse.getShopTel());
                break;
            // 复制订单号
            case R.id.copy:
                CommonUtils.copyToClipboard(mContext, mOrderDetailResponse.getOrderId());
                break;
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
        }
    }

    /**
     * 设置操作按钮显示
     *
     * @param orderDetailResponse
     */
    private void setBtnDisplay(OrderDetailResponse orderDetailResponse) {
        if (orderDetailResponse.isCanCancel())
            cancelOrderBtn.setVisibility(View.VISIBLE);
        if (orderDetailResponse.isCanDelete())
            deleteBtn.setVisibility(View.VISIBLE);
        if (orderDetailResponse.isCanPayment())
            payBtn.setVisibility(View.VISIBLE);
        if (orderDetailResponse.isCanDelayedReceipt())
            delayedReceiptBtn.setVisibility(View.VISIBLE);
        if (orderDetailResponse.isCanFindExpressInfo())
            findExpressInfoBtn.setVisibility(View.VISIBLE);
        if (orderDetailResponse.isCanReceipt())
            receiptBtn.setVisibility(View.VISIBLE);
        if (orderDetailResponse.isCanApplyRefund()) {
            applyRefundBtn.setVisibility(View.VISIBLE);
            applyRefundBtn.setText(orderDetailResponse.getApplyRefundButtonText());
        }
        if (orderDetailResponse.isCanRemindShipment())
            remindShipmentBtn.setVisibility(View.VISIBLE);
        if (orderDetailResponse.isCanRepeatSubmitOrder())
            repeatSubmitOrderBtn.setVisibility(View.VISIBLE);
    }

    /**
     * 取消订单
     */
    private void cancelOrderBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mPresenter.cancelOrder(mOrderDetailResponse.getOrderId());
            }
        }, "是否确定取消订单？", "取消", "确定");
    }

    /**
     * 付款
     */
    private void payBtn() {
        PayAgainParams params = new PayAgainParams();
        int count = 0;
        for (int i = 0; i < mOrderDetailResponse.getOrderItems().size(); i++)
            count += mOrderDetailResponse.getOrderItems().get(i).getQuantity();
        params.setmCountsTotal(count + "");
        params.setmCountsTotalPrice(mOrderDetailResponse.getOrderAmount() + "");
        params.setmWaitOrderId(mOrderDetailResponse.getOrderId());
        params.setPalyListType(mOrderDetailResponse.getOrderType());
        PayFailActivity.gotoActivity((Activity) mContext, params);
    }

    /**
     * 申请退款/售后（整单退）
     */
    private void applyRefundBtn() {
        BeforeApplyRefundRequest request = new BeforeApplyRefundRequest();
        request.setSkuId(-1);
        request.setOrderId(mOrderDetailResponse.getOrderId());
        IntentUtils.gotoActivity(mContext, ApplyRefundActivity.class, request);
    }

    /**
     * 提醒商家发货
     */
    private void remindShipmentBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mPresenter.remindShipment(mOrderDetailResponse.getOrderId());
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
                mPresenter.delayedReceipt(mOrderDetailResponse.getOrderId());
            }
        }, "是否延迟签收订单？", "取消", "确定");
    }

    /**
     * 删除订单
     */
    private void deleteBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mPresenter.deleteOrder(mOrderDetailResponse.getOrderId());
            }
        }, "是否确定删除订单？", "取消", "确定");
    }

    /**
     * 查看物流
     */
    private void findExpressInfoBtn() {
        IntentUtils.gotoActivity(mContext, ExpressInfoActivity.class, mOrderDetailResponse.getOrderId());
    }

    /**
     * 确认收货
     */
    private void receiptBtn() {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                mPresenter.receipt(mOrderDetailResponse.getOrderId());
            }
        }, "是否确认收货？", "取消", "确定");
    }

    /**
     * 再来一单
     */
    private void repeatSubmitOrderBtn() {
        AddToCartRequest request = new AddToCartRequest();
        List<AddToCartRequest.SkusBean> skusBeanList = new ArrayList<>();
        for (int i = 0; i < mOrderDetailResponse.getOrderItems().size(); i++) {
            AddToCartRequest.SkusBean skusBean = new AddToCartRequest.SkusBean();
            skusBean.setSkuId(mOrderDetailResponse.getOrderItems().get(i).getSkuId());
            skusBean.setQuantity(mOrderDetailResponse.getOrderItems().get(i).getQuantity());
            skusBeanList.add(skusBean);
        }
        request.setSkus(skusBeanList);

        mPresenter.repeatSubmitOrder(request);
    }


    /**
     * 删除订单成功回调
     */
    @Override
    public void deleteOrderSuccess() {
        IntentUtils.gotoOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_ALL);
        ToastUtils.toastShort("已删除");
    }

    /**
     * 取消订单成功回调
     */
    @Override
    public void cancelOrderSuccess() {
        IntentUtils.gotoOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_ALL);
        ToastUtils.toastShort("已取消");
    }

    /**
     * 延长收货成功回调
     */
    @Override
    public void delayedReceiptSuccess() {
        ToastUtils.toastShort("延迟成功");
    }

    /**
     * 确认收货成功回调
     */
    @Override
    public void receiptSuccess() {
        IntentUtils.gotoOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_ALL);
    }

    /**
     * 提醒商家发货成功回调
     */
    @Override
    public void remindShipmentSuccess() {
        ToastUtils.toastShort("已提醒");
    }

    /**
     * 再来一单成功回调
     *
     * @param request
     */
    @Override
    public void repeatSubmitOrderSuccess(AddToCartRequest request) {
        IntentUtils.gotoActivity(mContext, ShopCartActivity.class);
    }

}
