package com.coopbuy.mall.ui.module.test.presenter;


import android.content.Context;
import android.util.Log;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.okhttp.callback.StringCallback;
import com.coopbuy.mall.ui.module.test.model.TestModel;
import com.coopbuy.mall.ui.module.test.view.Test_IView;

import okhttp3.Call;

public class TestPresenter extends BasePresenter<Test_IView, TestModel> {
    public TestPresenter(Context context, TestModel model, Test_IView view) {
        super(context, model, view);
    }

    public void getData() {
        mView.showTransLoading();
        mModel.getData(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("yangmbin", "error happened");
                mView.showData("error happened");
                mView.stopLoading();
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("yangmbin", response);
                mView.showData(response);
                mView.stopLoading();
            }
        });
    }
}
