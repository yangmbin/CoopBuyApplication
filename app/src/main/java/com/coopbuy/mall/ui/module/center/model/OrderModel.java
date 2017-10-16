package com.coopbuy.mall.ui.module.center.model;


import com.coopbuy.mall.api.reponse.GetOrderListResponse;
import com.coopbuy.mall.api.request.GetOrderListRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class OrderModel implements BaseModel {



    /**
     * 获取所有订单列表
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getOrderAllList(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return client.getOrderAllList(request, callback, userState);
    }

    /**
     * 获取待付款订单
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getOrderListWaitForPayment(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return client.getOrderListWaitForPayment(request, callback, userState);
    }

    /**
     * 获取待发货订单
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getOrderListWaitForDispatch(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return client.getOrderListWaitForReceive(request, callback, userState);
    }

    /**
     * 获取待收货订单
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getOrderListWaitForReceive(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return client.getOrderListWaitForReceive(request, callback, userState);
    }

    /**
     * 获取待评价订单
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getOrderListWaitForComment(GetOrderListRequest request, IAsyncResultCallback<GetOrderListResponse> callback, Object userState) {
        return client.getOrderListWaitForComment(request, callback, userState);
    }
}
