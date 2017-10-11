package com.coopbuy.mall.ui.module.center.activity;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;

/**
 * @author csn
 * @time 2017/10/11 0011 14:14
 * @content 增加新客户
 */
public class AddCustomActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_add_custom;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(getString(R.string.title_add_mycustom));
    }
}
