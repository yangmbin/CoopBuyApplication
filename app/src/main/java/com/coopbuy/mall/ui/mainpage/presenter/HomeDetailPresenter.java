package com.coopbuy.mall.ui.mainpage.presenter;


import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.HomeDetailFloorResponse;
import com.coopbuy.mall.api.request.HomeDetailFloorRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.HomeDetailModel;
import com.coopbuy.mall.ui.mainpage.view.HomeDetail_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

public class HomeDetailPresenter extends BasePresenter<HomeDetail_IView, HomeDetailModel> {

    public HomeDetailPresenter(Context context, HomeDetailModel model, HomeDetail_IView view) {
        super(context, model, view);
    }

    /**
     * 获取活动详情
     */
    public void getHomeDetailData(int pageId, final boolean isPullToRefresh) {
        if (!isPullToRefresh)
            mView.showFillLoading();
        HomeDetailFloorRequest request = new HomeDetailFloorRequest();
        request.setPageId(pageId);
        mView.appendNetCall(mModel.getHomeDetailFloorList(request, new IAsyncResultCallback<HomeDetailFloorResponse>() {
            @Override
            public void onComplete(HomeDetailFloorResponse homeDetailFloorResponse, Object userState) {
                mView.setHomeDetailData(homeDetailFloorResponse);
                if (isPullToRefresh)
                    mView.stopPullToRefreshLoading();
                else
                    mView.stopAll();

                if (homeDetailFloorResponse.getFloorList().size() == 0)
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
        }, "获取活动详情"));
    }
}
