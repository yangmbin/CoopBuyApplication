package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.OrderPayApplyResponse;
import com.coopbuy.mall.api.reponse.OrderSubmitResponse;
import com.coopbuy.mall.api.reponse.TradeChannelResponse;
import com.coopbuy.mall.api.request.OrderPayApplyRequest;
import com.coopbuy.mall.api.request.OrderSubmitRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author wangyu
 * @time 2017/8/10 0010 on 上午 11:39
 * @desc
 */
public class NewPayWindow_Model implements BaseModel {

    /**
     * 订单提交
     *
     * @param request
     * @param callback
     * @param userState
     */
    public IAsyncRequestState orderSubmit(OrderSubmitRequest request, IAsyncResultCallback<OrderSubmitResponse> callback, Object userState) {
        return client.orderSubmit(request, callback, userState);
    }

   /* *//**
     * 获得可以支付通道
     *
     * @param callback
     * @param userState
     */
    public IAsyncRequestState getPayTradeChannel(IAsyncResultCallback<List<TradeChannelResponse>> callback, Object userState) {
        return client.getPayTradeChannel(callback, userState);
    }


/*

    */
/**
     * 订单支付申请，表示向服务器请求支付参数，获取支付参数后根据不同的支付通道调用相应的第三方支付组件进行支付
     * @param callback
     * @param userState
     * @return
     */

   public IAsyncRequestState orderPayApply(OrderPayApplyRequest request, IAsyncResultCallback<OrderPayApplyResponse> callback, Object userState) {
        return client.getPayParms(request,callback, userState);
    }



}
