package com.coopbuy.mall.ui.mainpage.presenter;


import android.content.Context;
import android.util.Log;

import com.coopbuy.mall.api.login.HomePageDataRequest;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.HomeModel;
import com.coopbuy.mall.ui.mainpage.view.Home_IView;
import com.google.gson.Gson;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

public class HomePresenter extends BasePresenter<Home_IView, HomeModel> {

    private Gson gson;

    public HomePresenter(Context context, HomeModel model, Home_IView view) {
        super(context, model, view);
        gson = new Gson();
    }

    /**
     * 获取首页数据
     */
    public void getHomeData(final boolean isPullToRefresh) {
        if (!isPullToRefresh)
            mView.showFillLoading();
        HomePageDataRequest homePageDataRequest = new HomePageDataRequest();
        homePageDataRequest.setPagekey("AppHome");
        mView.appendNetCall(mModel.homePageData(homePageDataRequest, new IAsyncResultCallback<HomePageDataResponse>() {
            @Override
            public void onComplete(HomePageDataResponse homePageDataResponse, Object userState) {
                Log.e("yangmbin", homePageDataResponse + "");
                mView.setHomeData(homePageDataResponse);
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
        }, "homePage"));
    }
}
