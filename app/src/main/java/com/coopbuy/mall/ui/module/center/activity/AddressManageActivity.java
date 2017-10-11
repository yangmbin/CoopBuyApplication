package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author csn
 * @time 2017/10/11 0011 14:43
 * @content 地址管理
 */
public class AddressManageActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_address_manage;
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


    @OnClick(R.id.tv_add_address)
    public void onViewClicked() {
        IntentUtils.gotoActivity(this, AddresssAddUserActivity.class);
    }
}
