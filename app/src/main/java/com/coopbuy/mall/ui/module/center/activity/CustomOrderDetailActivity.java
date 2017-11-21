package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CustomOrderDetailReponse;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.CustomOrderDetailModel;
import com.coopbuy.mall.ui.module.center.presenter.CustomOrderDetailPresenter;
import com.coopbuy.mall.ui.module.center.view.CustomOrderDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author csn
 * @time 2017/10/11 0011 9:35
 * @content 客户订单详情
 */
public class CustomOrderDetailActivity extends BaseActivity<CustomOrderDetailPresenter, CustomOrderDetailModel> implements CustomOrderDetail_IView {
    @Bind(R.id.tv_status)
    TextView tvStatus;
    @Bind(R.id.tv_time_end)
    TextView tvTimeEnd;
    @Bind(R.id.tv_logistics)
    TextView tvLogistics;
    @Bind(R.id.tv_time_send_new)
    TextView tvTimeSend;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.tv_preferential)
    TextView tvPreferential;
    @Bind(R.id.tv_feight)
    TextView tvFeight;
    @Bind(R.id.tv_meg)
    TextView tvMeg;
    @Bind(R.id.tv_all_price)
    TextView tvAllPrice;
    @Bind(R.id.tv_pay_price)
    TextView tvPayPrice;
    @Bind(R.id.tv_copy)
    TextView tvCopy;
    @Bind(R.id.rl_order_status)
    RelativeLayout rlOrderStatus;
    @Bind(R.id.tv_order_number)
    TextView tvOrderNumber;
    @Bind(R.id.tv_create_time)
    TextView tvCreateTime;
    @Bind(R.id.tv_pay_time)
    TextView tvPayTime;
    @Bind(R.id.tv_send_time)
    TextView tvSendTime;
    private OrderIdRequest request;

    @Override
    public int getLayoutId() {
        return R.layout.activity_station_order_detail;
    }

    @Override
    public void initModel() {
        mModel = new CustomOrderDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new CustomOrderDetailPresenter(this, mModel, this);
        mPresenter.getCustomOrderDetailData(request);
    }

    @Override
    public void initView() {
        setTitle("订单详情");
        request = new OrderIdRequest();
        if (null != getIntent()) {
            request.setOrderId(getIntent().getStringExtra(IntentUtils.PARAM1));
        }
    }

    @Override
    public void getData(CustomOrderDetailReponse bean) {
        tvStatus.setText(bean.getOrderStatusName());
        tvAddress.setText(bean.getConsignerAddress());
        tvAllPrice.setText("￥" + bean.getTotalAmount() + "");
        tvFeight.setText("￥" + bean.getFreightAmount() + "");
        if (null != bean.getCargoInfo()) {
            tvLogistics.setText(bean.getCargoInfo().getText());
            tvTimeSend.setText(bean.getCargoInfo().getTime());
        } else {
            tvLogistics.setText("暂时没有相关数据");
            tvTimeSend.setText("暂时没有相关数据");
        }
        tvMeg.setText("差字段");
        tvName.setText(bean.getConsignerName());
        tvPhone.setText(bean.getConsignerTel());
        tvOrderNumber.setText("订单编号：" + bean.getOrderId());
        tvCreateTime.setText("创建时间：" + bean.getCreateTime());
        if (TextUtils.isEmpty(bean.getPaymentTime())) {
            tvPayTime.setVisibility(View.GONE);
        } else {
            tvPayTime.setVisibility(View.VISIBLE);
            tvPayTime.setText("付款时间：" + bean.getPaymentTime());
        }
        if (TextUtils.isEmpty(bean.getPaymentTime())) {
            tvSendTime.setVisibility(View.GONE);
        } else {
            tvSendTime.setVisibility(View.VISIBLE);
            tvSendTime.setText("发货时间：" + bean.getShipmentTime());
        }
        tvPayPrice.setText("￥" + bean.getOrderAmount());
        setOrderStatus(bean);
    }

    private void setOrderStatus(CustomOrderDetailReponse bean) {
        int backImage = R.mipmap.default_img;
        switch (bean.getOrderStatus()) {
            case 1:
                backImage = R.mipmap.icon_wait_pay;
                break;
            case 2:
                backImage = R.mipmap.icon_wait_send;
                break;
            case 3:
                backImage = R.mipmap.icon_wait_received;
                break;
            case 4:
                backImage = R.mipmap.icon_deal_complete;
                break;
            case 5:
            case 6:
                backImage = R.mipmap.icon_deal_close;
                break;
        }
        rlOrderStatus.setBackgroundResource(backImage);
    }

}
