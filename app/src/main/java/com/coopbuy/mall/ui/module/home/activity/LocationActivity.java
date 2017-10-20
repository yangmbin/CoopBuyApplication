package com.coopbuy.mall.ui.module.home.activity;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.widget.navigation.NavSearchBar;

import butterknife.Bind;


public class LocationActivity extends BaseActivity {
    @Bind(R.id.navSearchBar)
    NavSearchBar navSearchBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_location;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        navSearchBar.setHint("城市名/拼音");
    }

}
