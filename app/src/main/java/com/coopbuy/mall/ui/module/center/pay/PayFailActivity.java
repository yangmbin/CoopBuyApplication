package com.coopbuy.mall.ui.module.center.pay;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.bean.PayAgainParms;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.OnClick;

/**
 * @author niu
 * @time 2017/11/3 10:42
 * @content 支付失败
 */
public class PayFailActivity extends BaseActivity {
    private PayAgainParms payAgainParms;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_fail;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("订单支付失败");
        if (null != getIntent()) {
            payAgainParms = (PayAgainParms) getIntent().getSerializableExtra(IntentUtils.DATA);
        }
    }

    @OnClick({R.id.tv_order_detail, R.id.tv_pay_again})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_order_detail:
                onBackPressed();
                break;
            case R.id.tv_pay_again:
                Intent intent = new Intent(this, NewPayWindowActivity.class);
                intent.putExtra("data", payAgainParms);
                intent.putExtra("type", "wait");
                startActivity(intent);
                overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
                break;
        }
    }

    /**
     * 跳转支付页面
     * @param activity
     * @param payAgainParms
     */
    public static void gotoActivity(Activity activity, PayAgainParms payAgainParms) {
        Intent intent = new Intent(activity, NewPayWindowActivity.class);
        intent.putExtra("data", payAgainParms);
        intent.putExtra("type", "wait");
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
    }

    @Override
    public void onBackPressed() {
        IntentUtils.gotoMainActivity(mContext, 2);
        IntentUtils.gotoMeOrderActivityWithClearTop(mContext, Constants.ORDER_TYPE_WAITPAY);
        this.finish();
    }
}
