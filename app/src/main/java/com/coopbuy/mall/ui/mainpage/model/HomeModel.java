package com.coopbuy.mall.ui.mainpage.model;


import com.coopbuy.mall.api.reponse.HomePageDataResponse;
import com.coopbuy.mall.api.request.HomePageDataRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class HomeModel implements BaseModel {

    public IAsyncRequestState homePageData(HomePageDataRequest request, IAsyncResultCallback<HomePageDataResponse> callback, Object userState) {
        return client.homePageData(request, callback, userState);
    }
}
