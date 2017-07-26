package com.coopbuy.mall.ui.module.test.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.test.model.TestModel;
import com.coopbuy.mall.ui.module.test.presenter.TestPresenter;
import com.coopbuy.mall.ui.module.test.view.Test_IView;
import com.coopbuy.mall.utils.IntentUtils;

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
        setTitle("页面1");
        setRightText("测试");
    }

    @Override
    public void showData(String str) {
        tv_data.setText(str);
    }

    @Override
    public void clickTitleBarRight() {
        super.clickTitleBarRight();
        Toast.makeText(mContext, "点文字干嘛", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_show, R.id.btn_jump})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                mPresenter.getData();
                break;
            case R.id.btn_jump:
                IntentUtils.gotoActivity(mContext, SecondActivity.class);
                break;
        }
    }

}
