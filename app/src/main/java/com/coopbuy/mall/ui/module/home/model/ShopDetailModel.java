package com.coopbuy.mall.ui.module.home.model;

import com.coopbuy.mall.api.reponse.ShopDetailResponse;
import com.coopbuy.mall.api.request.ShopIdRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class ShopDetailModel implements BaseModel {
    public IAsyncRequestState getShopDetail(ShopIdRequest request, IAsyncResultCallback<ShopDetailResponse> callback, Object userState) {
        return client.getShopDetail(request, callback, userState);
    }

    public IAsyncRequestState addShopFavorite(ShopIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.addShopFavorite(request, callback, userState);
    }

    public IAsyncRequestState removeShopFavorite(ShopIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.removeShopFavorite(request, callback, userState);
    }
}
