package com.coopbuy.mall.ui.mainpage.model;


import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;


public class HomeModel implements BaseModel {

    public IAsyncRequestState getHomeFloorList(IAsyncResultCallback<List<HomeFloorResponse>> callback, Object userState) {
        return client.getHomeFloorList(callback, userState);
    }
}
