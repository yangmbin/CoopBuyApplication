package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class PhoneChargeActivity extends BaseActivity {
    @Bind(R.id.edit_phone)
    EditText editPhone;
    @Bind(R.id.tv_charge)
    TextView tvCharge;
    @Bind(R.id.swipe_target)
    RecyclerView swipeTarget;
    @Bind(R.id.tv_charge_number)
    TextView tvChargeNumber;

    @Override
    public int getLayoutId() {
        return R.layout.activity_phone_charge;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(R.string.title_charge);
    }

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
    }
}
