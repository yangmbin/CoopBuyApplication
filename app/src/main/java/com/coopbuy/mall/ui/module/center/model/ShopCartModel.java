package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.ShopCartReponse;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/10/24.
 */

public class ShopCartModel implements BaseModel {
    public IAsyncRequestState getShopCartData(IAsyncResultCallback<ShopCartReponse> callback, Object userState) {
        return client.getShopCartData(callback, userState);
    }
}
