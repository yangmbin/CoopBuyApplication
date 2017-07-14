package com.coopbuy.mall.ui.test.activity;

import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.test.model.TestModel;
import com.coopbuy.mall.ui.test.presenter.TestPresenter;
import com.coopbuy.mall.ui.test.view.Test_IView;

import butterknife.Bind;
import butterknife.OnClick;

public class TestActivity extends BaseActivity<TestPresenter, TestModel> implements Test_IView {

    @Bind(R.id.tv_data)
    TextView tv_data;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initModel() {
        mModel = new TestModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new TestPresenter(mContext, mModel, this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void showData(String str) {
        tv_data.setText(str);
    }

    @OnClick({R.id.btn_show})
    public void onViewClicked(View v) {
        mPresenter.getData();
    }
}
