package com.coopbuy.mall.ui.module.center.activity;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

public class MyBillActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_my_bill;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(R.string.title_bill);
        setRightText(R.string.lab_bill_filter);
        ToastUtils.toastLong("进入详情");
        IntentUtils.gotoActivity(this, BillDetailActivity.class);
    }
}
