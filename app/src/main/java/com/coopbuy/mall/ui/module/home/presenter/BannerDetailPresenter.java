package com.coopbuy.mall.ui.module.home.presenter;


import android.content.Context;
import android.util.Log;

import com.coopbuy.mall.api.login.HomePageDataByIdRequest;
import com.coopbuy.mall.api.login.HomePageDataByIdResponse;
import com.coopbuy.mall.api.login.HomePageDataRequest;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.HomeModel;
import com.coopbuy.mall.ui.mainpage.model.MainModel;
import com.coopbuy.mall.ui.mainpage.view.Home_IView;
import com.coopbuy.mall.ui.mainpage.view.Main_IView;
import com.coopbuy.mall.ui.module.home.model.BannerDetailModel;
import com.coopbuy.mall.ui.module.home.view.BannerDetail_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.google.gson.Gson;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

public class BannerDetailPresenter extends BasePresenter<BannerDetail_IView, BannerDetailModel> {

    private Gson gson;

    public BannerDetailPresenter(Context context, BannerDetailModel model, BannerDetail_IView view) {
        super(context, model, view);
        gson = new Gson();
    }

    /**
     * 获取banner图详情
     */
    public void getBannerDetailData(String ObjectId, final boolean isPullToRefresh) {
        if (!isPullToRefresh)
            mView.showFillLoading();
        HomePageDataByIdRequest homePageDataByIdRequest = new HomePageDataByIdRequest();
        homePageDataByIdRequest.setPageId(ObjectId);
        mModel.getPageDataById(homePageDataByIdRequest, new IAsyncResultCallback<HomePageDataByIdResponse>() {
            @Override
            public void onComplete(HomePageDataByIdResponse homePageDataByIdResponse, Object userState) {
                mView.setBannerDetailData(homePageDataByIdResponse);
                mView.stopAll();
                if (isPullToRefresh)
                    mView.stopPullToRefreshLoading();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.showNetErrorLayout();
                if (isPullToRefresh)
                    mView.stopPullToRefreshLoading();
            }
        }, "banner");

    }
}
