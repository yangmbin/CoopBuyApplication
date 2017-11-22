package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.PayOntherDetailReponse;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.PayOtherDetailModel;
import com.coopbuy.mall.ui.module.center.presenter.PayOtherDetailPresenter;
import com.coopbuy.mall.ui.module.center.view.PayOtherDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author niu
 * @time 2017/11/21 10:42
 * @content 这里分了查看详情  还有代付成功 代付失败也是在这里
 */
public class PayOtherDetailActivity extends BaseActivity<PayOtherDetailPresenter, PayOtherDetailModel> implements PayOtherDetail_IView {
    @Bind(R.id.tv_hint)
    TextView tvHint;
    @Bind(R.id.circleImageView)
    SimpleDraweeView circleImageView;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.ll_call)
    LinearLayout llCall;
    @Bind(R.id.tv_apply_price)
    TextView tvApplyPrice;
    @Bind(R.id.tv_apply_status)
    TextView tvApplyStatus;
    @Bind(R.id.tv_apply_name)
    TextView tvApplyName;
    @Bind(R.id.tv_create_time)
    TextView tvCreateTime;
    @Bind(R.id.tv_apply_time)
    TextView tvApplyTime;
    @Bind(R.id.tv_order_number)
    TextView tvOrderNumber;
    @Bind(R.id.tv_copy)
    TextView tvCopy;
    @Bind(R.id.tv_address_detail)
    TextView tvAddressDetail;
    @Bind(R.id.tv_order_close_hint)
    TextView tvOrderCloseHint;
    @Bind(R.id.tv_refuse)
    TextView tvRefuse;
    @Bind(R.id.tv_pay)
    TextView tvPay;
    /**
     * 代付成功显示
     */
    @Bind(R.id.tv_see_order_success)
    TextView tvSeeOrderSuccess;
    /**
     * 代付失败显示
     */
    @Bind(R.id.tv_see_order_fail)
    TextView tvSeeOrderFail;
    /**
     * 代付失败显示再支付
     */
    @Bind(R.id.tv_pay_again)
    TextView tvPayAgain;
    /**
     * 代付历史进入
     */
    @Bind(R.id.rl_alreadypay_pay)
    RelativeLayout rlAlreadypayPay;
    /**
     * 有代付申请点击进入
     */
    @Bind(R.id.rl_wait_pay)
    RelativeLayout rlWaitPay;
    /**
     * 代付  如果是查看详情是不需要显示的
     */
    @Bind(R.id.rl_apply_hint)
    RelativeLayout rlApplyHint;
    /**
     * 代付提示  代付成功 代付失败
     */
    @Bind(R.id.tv_apply_hint)
    TextView tvTvApplyHint;
    /**
     * 代付时间提示  代付成功 代付失败
     */
    @Bind(R.id.tv_apply_time_hint)
    TextView tvApplyTimeHint;
    private OrderIdRequest request;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_other_detail;
    }

    @Override
    public void initModel() {
        mModel = new PayOtherDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new PayOtherDetailPresenter(this, mModel, this);
        mPresenter.getData(request);
    }

    @Override
    public void initView() {
        setTitle("代付详情");
        if (null != getIntent()) {
            request.setOrderId(getIntent().getStringExtra(IntentUtils.PARAM1));

        }
    }

    @Override
    public void getData(PayOntherDetailReponse bean) {
        tvAddressDetail.setText(bean.getAddress());
        tvApplyName.setText(bean.getConsignerName());
        tvName.setText(bean.getConsignerName());
        tvApplyPrice.setText("" + bean.getApplyAmount());
        tvOrderNumber.setText(bean.getOrderId());
        tvApplyStatus.setText(bean.getStatusName());
        tvApplyTime.setText(bean.getApplyTime());
        tvCreateTime.setText(bean.getOrderTime());


    }

    private void setStatus(PayOntherDetailReponse bean) {
        //这里应该根据状态来显示 对应的按钮  这里是我自己定义的 得等后期有时间在定义
        if (bean.getStatus() == 1) {
            tvHint.setVisibility(View.VISIBLE);
            rlApplyHint.setVisibility(View.GONE);
            tvApplyTimeHint.setVisibility(View.VISIBLE);
        } else {
            tvHint.setVisibility(View.GONE);
            rlApplyHint.setVisibility(View.VISIBLE);
            tvApplyTimeHint.setVisibility(View.GONE);
            if (bean.getStatus() == 3) {
                tvTvApplyHint.setText("代付成功时间");
                tvSeeOrderFail.setVisibility(View.GONE);
                tvPayAgain.setVisibility(View.GONE);
                tvSeeOrderSuccess.setVisibility(View.VISIBLE);
            } else if (bean.getStatus() == 3) {
                tvApplyStatus.setTextColor(this.getResources().getColor(R.color.auxiliary_text_red));
                tvTvApplyHint.setText("代付失败时间");
                tvSeeOrderFail.setVisibility(View.VISIBLE);
                tvPayAgain.setVisibility(View.VISIBLE);
                tvSeeOrderSuccess.setVisibility(View.GONE);
            }
        }
    }

    @OnClick({R.id.tv_refuse, R.id.tv_pay, R.id.tv_see_order_success, R.id.tv_see_order_fail, R.id.tv_pay_again})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_refuse:

                break;
            case R.id.tv_pay:

                break;
            case R.id.tv_see_order_success:

                break;
            case R.id.tv_see_order_fail:

                break;
            case R.id.tv_pay_again:

                break;
        }
    }
}
