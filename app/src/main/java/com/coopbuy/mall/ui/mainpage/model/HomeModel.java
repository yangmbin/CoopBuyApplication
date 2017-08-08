package com.coopbuy.mall.ui.mainpage.model;

import com.coopbuy.mall.api.login.HomePageDataRequest;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;


public class HomeModel implements BaseModel {

    LoginClient client = new LoginClient();

    public void homePageData(HomePageDataRequest request, IAsyncResultCallback<HomePageDataResponse> callback, Object userState) {
        client.homePageData(request, callback, userState);
    }
}
