package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.api.login.OrderDetailRequest;
import com.coopbuy.mall.api.login.OrderDetailResponse;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;


public class OrderDetailModel implements BaseModel {

    LoginClient client = new LoginClient();

    /**
     * 获取订单详情
     * @param request
     * @param callback
     * @param userState
     */
    public void getOrderDetail(OrderDetailRequest request, IAsyncResultCallback<OrderDetailResponse> callback, Object userState) {
        client.getOrderDetail(request, callback, userState);
    }
}
