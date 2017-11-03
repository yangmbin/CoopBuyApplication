package com.coopbuy.mall.ui.module.center.pay;

import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author niu
 * @time 2017/11/3 10:42
 * @content 支付成功
 */
public class PaySuccessActivity extends BaseActivity {

    @Bind(R.id.tv_order_paycount)
    TextView tvOrderPaycounts;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_success;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("订单支付成功");
        if (null != getIntent()) {
            tvOrderPaycounts.setText("￥" + getIntent().getStringExtra(IntentUtils.PARAM1));
        }
    }

    @OnClick({R.id.tv_order_detail, R.id.tv_go_home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_order_detail:
                onBackPressed();
                break;
            case R.id.tv_go_home:
                IntentUtils.gotoMainActivity(mContext, 0);
                this.finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        IntentUtils.gotoMainActivity(mContext, 2);
        IntentUtils.gotoMeOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_WAITSEND);
        this.finish();
    }
}
