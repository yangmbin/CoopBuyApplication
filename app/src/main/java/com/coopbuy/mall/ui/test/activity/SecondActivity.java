package com.coopbuy.mall.ui.test.activity;

import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.test.model.SecondModel;
import com.coopbuy.mall.ui.test.presenter.SecondPresenter;
import com.coopbuy.mall.ui.test.view.Second_IView;

import butterknife.Bind;

public class SecondActivity extends BaseActivity<SecondPresenter, SecondModel> implements Second_IView {

    @Bind(R.id.tv_data)
    TextView tv_data;

    @Override
    public int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    public void initModel() {
        mModel = new SecondModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new SecondPresenter(mContext, mModel, this);
        mPresenter.getData();
    }

    @Override
    public void initView() {
    }

    @Override
    public void showData(String str) {
        tv_data.setText(str);
    }
}
