package com.coopbuy.mall.ui.mainpage.model;


import com.coopbuy.mall.api.reponse.HomeDetailFloorResponse;
import com.coopbuy.mall.api.request.HomeDetailFloorRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class HomeDetailModel implements BaseModel {

    public IAsyncRequestState getHomeDetailFloorList(HomeDetailFloorRequest request, IAsyncResultCallback<HomeDetailFloorResponse> callback, Object userState) {
        return client.getHomeDetailFloorList(request, callback, userState);
    }
}
