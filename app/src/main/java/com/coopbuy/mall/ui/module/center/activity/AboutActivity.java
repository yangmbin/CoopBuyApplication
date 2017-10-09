package com.coopbuy.mall.ui.module.center.activity;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;

public class AboutActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(R.string.title_about);
    }
}
