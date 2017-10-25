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
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.StringUtils;

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
    private OrderDetailAdapter mOrderDetailAdapter;
    private List<OrderDetailResponse.OrderItemsBean> mDatas = new ArrayList<>();

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
        createTime.setText("创建时间：" + orderDetailResponse.getCreateTime());
        // 付款时间
        payTime.setText("付款时间：" + orderDetailResponse.getPaymentTime());
        // 完成时间
        finishTime.setText("完成时间：" + orderDetailResponse.getFinishTime());
    }

    /**
     * 点击事件监听
     *
     * @param view
     */
    @OnClick({R.id.contact_service, R.id.dial_phone, R.id.copy})
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

                break;
        }
    }
}
