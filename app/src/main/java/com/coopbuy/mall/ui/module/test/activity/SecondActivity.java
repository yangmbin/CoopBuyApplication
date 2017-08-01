package com.coopbuy.mall.ui.module.test.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.annotation.AspectAnnotation;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.test.model.SecondModel;
import com.coopbuy.mall.ui.module.test.presenter.SecondPresenter;
import com.coopbuy.mall.ui.module.test.view.Second_IView;
import com.coopbuy.mall.utils.ToastUtils;

import butterknife.Bind;

public class SecondActivity extends BaseActivity<SecondPresenter, SecondModel> implements Second_IView {

    @Bind(R.id.tv_data)
    TextView tv_data;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ToastUtils.toastShort( "检测通过");
        }
    };

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
        setTitle("页面2");
        setRightImage(R.mipmap.ic_launcher);
//        setData();
    }

    @Override
    public void showData(String str) {
        tv_data.setText(str);
    }

    @Override
    public void clickTitleBarRight() {
        super.clickTitleBarRight();
        ToastUtils.toastShort( "点图片干嘛");
    }

    @AspectAnnotation("")
    public void setData(){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mHandler.sendEmptyMessage(0);
            }
        },3000);
    }

    @Override
    protected void networkRetry() {
        super.networkRetry();

        ToastUtils.toastShort( "reload");
    }
}
