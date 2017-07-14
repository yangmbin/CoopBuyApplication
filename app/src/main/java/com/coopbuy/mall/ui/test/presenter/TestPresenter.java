package com.coopbuy.mall.ui.test.presenter;


import android.content.Context;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.test.model.TestModel;
import com.coopbuy.mall.ui.test.view.Test_IView;

public class TestPresenter extends BasePresenter<Test_IView, TestModel> {
    public TestPresenter(Context context, TestModel model, Test_IView view) {
        super(context, model, view);
    }

    public void getData() {
        String str = mModel.getData();
        mView.showData(str);
    }
}
