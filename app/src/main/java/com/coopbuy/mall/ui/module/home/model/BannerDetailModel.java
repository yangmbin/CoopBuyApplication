package com.coopbuy.mall.ui.module.home.model;


import com.coopbuy.mall.api.reponse.HomePageDataByIdResponse;
import com.coopbuy.mall.api.request.HomePageDataByIdRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class BannerDetailModel implements BaseModel {
    public IAsyncRequestState getPageDataById(HomePageDataByIdRequest request, IAsyncResultCallback<HomePageDataByIdResponse> callback, Object userState) {
       return client.getPageDataById(request, callback, userState);
    }
}
