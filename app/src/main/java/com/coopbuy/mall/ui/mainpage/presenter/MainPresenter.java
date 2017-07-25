package com.coopbuy.mall.ui.mainpage.presenter;


import android.content.Context;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.MainModel;
import com.coopbuy.mall.ui.mainpage.view.Main_IView;

public class MainPresenter extends BasePresenter<Main_IView, MainModel> {
    public MainPresenter(Context context, MainModel model, Main_IView view) {
        super(context, model, view);
    }
}
