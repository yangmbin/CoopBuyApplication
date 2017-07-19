package com.coopbuy.mall.ui.test.presenter;


import android.content.Context;
import android.util.Log;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.okhttp.callback.StringCallback;
import com.coopbuy.mall.ui.test.model.SecondModel;
import com.coopbuy.mall.ui.test.view.Second_IView;

import okhttp3.Call;

public class SecondPresenter extends BasePresenter<Second_IView, SecondModel> {
    public SecondPresenter(Context context, SecondModel model, Second_IView view) {
        super(context, model, view);
    }

    public void getData() {
        mView.showFillLoading();
//        SystemClock.sleep(1000);
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
