package com.coopbuy.mall.ui.module.center.activity;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;

public class MyCustomActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_custom;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(getString(R.string.title_custom));
        setRightText(getString(R.string.lab_custom_add));
    }

    @Override
    public void clickTitleBarRight() {
        super.clickTitleBarRight();
        IntentUtils.gotoActivity(this, AddCustomActivity.class);
    }
}
