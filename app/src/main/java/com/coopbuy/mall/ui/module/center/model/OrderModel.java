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

    /**
     * 获取待付款订单
     * @param request
     * @param callback
     * @param userState
     */
    public void getOrderListWaitForPayment(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderListWaitForPayment(request, callback, userState);
    }

    /**
     * 获取待发货订单
     * @param request
     * @param callback
     * @param userState
     */
    public void getOrderListWaitForDispatch(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderListWaitForReceive(request, callback, userState);
    }

    /**
     * 获取待收货订单
     * @param request
     * @param callback
     * @param userState
     */
    public void getOrderListWaitForReceive(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderListWaitForReceive(request, callback, userState);
    }

    /**
     * 获取待评价订单
     * @param request
     * @param callback
     * @param userState
     */
    public void getOrderListWaitForComment(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        client.getOrderListWaitForComment(request, callback, userState);
    }
}
