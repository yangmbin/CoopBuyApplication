package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddresssAddUserActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_addresss_add;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }


    @OnClick(R.id.btn_next)
    public void onViewClicked() {
        IntentUtils.gotoActivity(this, AddresssAddDetailActivity.class);
    }
}
