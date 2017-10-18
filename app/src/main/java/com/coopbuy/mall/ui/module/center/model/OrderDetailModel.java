package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.request.OrderDetailRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class OrderDetailModel implements BaseModel {

    /**
     * 获取订单详情
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getOrderDetail(OrderDetailRequest request, IAsyncResultCallback<OrderDetailResponse> callback, Object userState) {
        return client.getOrderDetail(request, callback, userState);
    }
}
