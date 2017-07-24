package com.coopbuy.mall.ui.test.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.coopbuy.mall.R;
import com.coopbuy.mall.annotation.AspectAnnotation;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.test.model.SecondModel;
import com.coopbuy.mall.ui.test.presenter.SecondPresenter;
import com.coopbuy.mall.ui.test.view.Second_IView;
import butterknife.Bind;

public class SecondActivity extends BaseActivity<SecondPresenter, SecondModel> implements Second_IView {

    @Bind(R.id.tv_data)
    TextView tv_data;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(mContext,"检测通过",Toast.LENGTH_SHORT).show();
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
        setData();
    }

    @Override
    public void showData(String str) {
        tv_data.setText(str);
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
}
