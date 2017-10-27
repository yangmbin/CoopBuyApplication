package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.OrderDetailAdapter;
import com.coopbuy.mall.ui.module.center.model.OrderDetailModel;
import com.coopbuy.mall.ui.module.center.presenter.OrderDetailPresenter;
import com.coopbuy.mall.ui.module.center.view.OrderDetail_IView;
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
    @Bind(R.id.lieuPayBtn)
    TextView lieuPayBtn;
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
        mOrderDetailAdapter = new OrderDetailAdapter(mContext, mDatas);
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

        // 设置商品列表
        mDatas.clear();
        mDatas.addAll(orderDetailResponse.getOrderItems());
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
    @OnClick({R.id.contact_service, R.id.dial_phone, R.id.copy, R.id.lieuPayBtn, R.id.cancelOrderBtn, R.id.payBtn, R.id.applyRefundBtn, R.id.remindShipmentBtn, R.id.delayedReceiptBtn, R.id.deleteBtn, R.id.findExpressInfoBtn, R.id.receiptBtn, R.id.repeatSubmitOrderBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 联系客服
            case R.id.contact_service:
                break;
            // 拨打商家电话
            case R.id.dial_phone:
                break;
            // 复制订单号
            case R.id.copy:
                CommonUtils.copyToClipboard(mContext, mOrderDetailResponse.getOrderId());
                break;
            // 站长代付
            case R.id.lieuPayBtn:
                lieuPayBtn();
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
        if (orderDetailResponse.isCanApplyLieuPay())
            lieuPayBtn.setVisibility(View.VISIBLE);
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
     * 站长代付
     */
    private void lieuPayBtn() {

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

    }

    /**
     * 申请退款/售后
     */
    private void applyRefundBtn() {

    }

    /**
     * 提醒商家发货
     */
    private void remindShipmentBtn() {

    }

    /**
     * 延长收货
     */
    private void delayedReceiptBtn() {

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

    }

    /**
     * 再来一单
     */
    private void repeatSubmitOrderBtn() {

    }


    /**
     * 删除订单成功回调
     */
    public void deleteOrderSuccess() {
        IntentUtils.gotoOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_ALL);
        ToastUtils.toastShort("已删除");
    }

    /**
     * 取消订单成功回调
     */
    public void cancelOrderSuccess() {
        IntentUtils.gotoOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_ALL);
        ToastUtils.toastShort("已取消");
    }
}
