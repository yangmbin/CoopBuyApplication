package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.OrderBuildResponse;
import com.coopbuy.mall.api.reponse.OrderSubmitResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.OrderBuildRequest;
import com.coopbuy.mall.api.request.OrderSubmitRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/10/26- 14:01
 */

public class OrderBuildModel implements BaseModel {
    public IAsyncRequestState getOrderBuildData(OrderBuildRequest request, IAsyncResultCallback<OrderBuildResponse> callback, Object userState) {
        return client.getOrderBuildData(request, callback, userState);
    }
    public IAsyncRequestState orderSubmit(OrderSubmitRequest request, IAsyncResultCallback<OrderSubmitResponse> callback, Object userState) {
        return client.orderSubmit(request, callback, userState);
    }
}
