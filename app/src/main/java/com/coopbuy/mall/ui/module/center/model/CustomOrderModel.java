package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.CustomOrderReponse;
import com.coopbuy.mall.api.reponse.OrderSubmitResponse;
import com.coopbuy.mall.api.request.AddUpdateCustomRequest;
import com.coopbuy.mall.api.request.CustomOrderRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public class CustomOrderModel implements BaseModel {
    public IAsyncRequestState getCustomOrder(CustomOrderRequest request, IAsyncResultCallback<CustomOrderReponse> callback , Object userState) {
        return client.getCustomOrder(request, callback, userState);
    }
}
