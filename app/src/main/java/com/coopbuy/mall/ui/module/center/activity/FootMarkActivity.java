package com.coopbuy.mall.ui.module.center.activity;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.FootMarkModel;
import com.coopbuy.mall.ui.module.center.presenter.FootMarkPresenter;
import com.coopbuy.mall.ui.module.center.view.FootMark_IView;

public class FootMarkActivity extends BaseActivity<FootMarkPresenter, FootMarkModel> implements FootMark_IView {


    @Override
    public int getLayoutId() {
        return R.layout.activity_foot_mark;
    }

    @Override
    public void initModel() {
        mModel = new FootMarkModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new FootMarkPresenter(this, mModel, this);
    }

    @Override
    public void initView() {
        setTitle("足迹");
    }
}
