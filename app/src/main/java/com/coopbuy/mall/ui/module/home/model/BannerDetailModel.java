package com.coopbuy.mall.ui.module.home.model;

import com.coopbuy.mall.api.login.HomePageDataByIdRequest;
import com.coopbuy.mall.api.login.HomePageDataByIdResponse;
import com.coopbuy.mall.api.login.NetClientManager;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class BannerDetailModel implements BaseModel {
    public IAsyncRequestState getPageDataById(HomePageDataByIdRequest request, IAsyncResultCallback<HomePageDataByIdResponse> callback, Object userState) {
       return client.getPageDataById(request, callback, userState);
    }
}
