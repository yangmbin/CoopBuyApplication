package com.coopbuy.mall.ui.mainpage.presenter;


import android.content.Context;
import android.util.Log;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.HomePageDataRequest;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.HomeModel;
import com.coopbuy.mall.ui.mainpage.view.Home_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.google.gson.Gson;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

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
                if (isPullToRefresh)
                    mView.stopPullToRefreshLoading();
                else
                    mView.stopAll();

                if (homePageDataResponse.getFloors().size() == 0)
                    mView.showNoDataLayout();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (isPullToRefresh)
                    mView.stopPullToRefreshLoading();
                else
                    mView.stopAll();

                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE) {
                    if (!isPullToRefresh)
                        mView.showNetOffLayout();
                    ToastUtils.toastShort(R.string.no_network);
                } else {
                    if (!isPullToRefresh)
                        mView.showNetErrorLayout();
                    ToastUtils.toastShort(R.string.connect_server_error);
                }
            }
        }, "homePage"));
    }
}
