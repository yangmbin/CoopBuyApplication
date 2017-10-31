package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.ShopStoreReponse;
import com.coopbuy.mall.api.request.ShopSotreCancelRequest;
import com.coopbuy.mall.api.request.ShopCurrentPageRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/10/27- 16:48
 */

public class ShopStoreModel implements BaseModel {
    public IAsyncRequestState getShopStoreList(ShopCurrentPageRequest request, IAsyncResultCallback<ShopStoreReponse> callback, Object userState) {
        return client.getShopStoreList(request, callback, userState);
    }
    public IAsyncRequestState setShopStoreList(ShopSotreCancelRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.shopStoreCancel(request, callback, userState);
    }
}
