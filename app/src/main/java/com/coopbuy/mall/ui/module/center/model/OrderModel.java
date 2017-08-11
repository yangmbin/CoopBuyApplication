package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.login.GetOrderListRequest;
import com.coopbuy.mall.api.login.GetOrderListResponse;
import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;


public class OrderModel implements BaseModel {

    LoginClient client = new LoginClient();

    /**
     * 获取所有订单列表
     * @param request
     * @param callback
     * @param userState
     */
    public void getOrderAllList(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderAllList(request, callback, userState);
    }
}
