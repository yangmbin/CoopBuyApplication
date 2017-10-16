package com.coopbuy.mall.ui.module.home.presenter;


import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.HomePageDataByIdResponse;
import com.coopbuy.mall.api.request.HomePageDataByIdRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.home.model.BannerDetailModel;
import com.coopbuy.mall.ui.module.home.view.BannerDetail_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.google.gson.Gson;
import com.guinong.net.CodeContant;
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
        mView.appendNetCall(mModel.getPageDataById(homePageDataByIdRequest, new IAsyncResultCallback<HomePageDataByIdResponse>() {
            @Override
            public void onComplete(HomePageDataByIdResponse homePageDataByIdResponse, Object userState) {
                mView.setBannerDetailData(homePageDataByIdResponse);
                if (isPullToRefresh)
                    mView.stopPullToRefreshLoading();
                else
                    mView.stopAll();

                if (homePageDataByIdResponse == null || homePageDataByIdResponse.getFloors().size() == 0)
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
        }, "banner"));

    }
}
