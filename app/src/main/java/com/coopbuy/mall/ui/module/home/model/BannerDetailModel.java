package com.coopbuy.mall.ui.module.home.model;

import com.coopbuy.mall.api.login.HomePageDataByIdRequest;
import com.coopbuy.mall.api.login.HomePageDataByIdResponse;
import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;


public class BannerDetailModel implements BaseModel {
    LoginClient client = new LoginClient();

    public void getPageDataById(HomePageDataByIdRequest request, IAsyncResultCallback<HomePageDataByIdResponse> callback, Object userState) {
        client.getPageDataById(request, callback, userState);
    }
}
