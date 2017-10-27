package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.OrderBuildResponse;
import com.coopbuy.mall.api.reponse.ShopStoreReponse;
import com.coopbuy.mall.api.request.OrderBuildRequest;
import com.coopbuy.mall.api.request.ShopSotreCancelRequest;
import com.coopbuy.mall.api.request.ShopStoreRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/10/27- 16:48
 */

public class ShopStoreModel implements BaseModel {
    public IAsyncRequestState getShopStoreList(ShopStoreRequest request, IAsyncResultCallback<ShopStoreReponse> callback, Object userState) {
        return client.getShopStoreList(request, callback, userState);
    }
    public IAsyncRequestState setShopStoreList(ShopSotreCancelRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.shopStoreCancel(request, callback, userState);
    }
}
