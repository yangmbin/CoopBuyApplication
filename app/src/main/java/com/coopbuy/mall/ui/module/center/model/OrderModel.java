package com.coopbuy.mall.ui.module.center.model;


import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.api.request.AddToCartRequest;
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

    /**
     * 延长收货
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState delayedReceipt(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.delayedReceipt(request, callback, userState);
    }

    /**
     * 确认收货
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState receipt(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.receipt(request, callback, userState);
    }

    /**
     * 提醒商家发货
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState remindShipment(OrderIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.remindShipment(request, callback, userState);
    }

    /**
     * 再来一单
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState addToCart(AddToCartRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.addToCart(request, callback, userState);
    }
}
