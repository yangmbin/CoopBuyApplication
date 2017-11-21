package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.CustomOrderDetailReponse;
import com.coopbuy.mall.api.reponse.CustomOrderReponse;
import com.coopbuy.mall.api.request.CustomOrderRequest;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public class CustomOrderDetailModel implements BaseModel {
    public IAsyncRequestState getCustomOrderDetail(OrderIdRequest request, IAsyncResultCallback<CustomOrderDetailReponse> callback , Object userState) {
        return client.getCustomOrderDetail(request, callback, userState);
    }
}
