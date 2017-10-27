package com.coopbuy.mall.ui.module.center.model;


import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.api.request.OrderListRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class OrderModel implements BaseModel {


    /**
     * 订单列表
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderList(OrderListRequest request, IAsyncResultCallback<OrderListResponse> callback, Object userState) {
        return client.getOrderList(request, callback, userState);
    }

    /**
     * 删除订单
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState deleteOrder(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.deleteOrder(request, callback, userState);
    }

    /**
     * 取消订单
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState cancelOrder(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.cancelOrder(request, callback, userState);
    }
}
