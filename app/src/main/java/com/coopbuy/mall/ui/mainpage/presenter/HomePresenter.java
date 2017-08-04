package com.coopbuy.mall.ui.mainpage.presenter;


import android.content.Context;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.HomeModel;
import com.coopbuy.mall.ui.mainpage.view.Home_IView;

public class HomePresenter extends BasePresenter<Home_IView, HomeModel> {

    public HomePresenter(Context context, HomeModel model, Home_IView view) {
        super(context, model, view);
    }

}
