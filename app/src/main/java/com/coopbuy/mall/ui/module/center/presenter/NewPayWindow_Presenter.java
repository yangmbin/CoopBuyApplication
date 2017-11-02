package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.OrderPayApplyResponse;
import com.coopbuy.mall.api.reponse.OrderSubmitResponse;
import com.coopbuy.mall.api.reponse.TradeChannelResponse;
import com.coopbuy.mall.api.request.OrderPayApplyRequest;
import com.coopbuy.mall.api.request.OrderSubmitRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.NewPayWindow_Model;
import com.coopbuy.mall.ui.module.center.view.NewPayWindow_View;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;


import java.util.List;

/**
 * @author wangyu
 * @time 2017/8/10 0010 on 上午 11:38
 * @desc
 */
public class NewPayWindow_Presenter extends BasePresenter<NewPayWindow_View, NewPayWindow_Model> {

    public NewPayWindow_Presenter(Context mContext, NewPayWindow_Model mModel, NewPayWindow_View mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 订单提交
     *
     * @param request
     */
    public void orderSubmit(OrderSubmitRequest request, final String payType) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.orderSubmit(request, new IAsyncResultCallback<OrderSubmitResponse>() {
            @Override
            public void onComplete(OrderSubmitResponse response, Object userState) {
                mView.submitOrder(response, payType);
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastLong((null != error.getMessage() ? error.getMessage() : ""));
                mView.stopAll();
            }
        }, 3));
    }

    /**
     * 获得可以支付通道
     */
    public void getPayTradeChannel() {
        //15 表示所有的渠道
        mView.showTransLoading();
        mView.appendNetCall(mModel.getPayTradeChannel(new IAsyncResultCallback<List<TradeChannelResponse>>() {
            @Override
            public void onComplete(List<TradeChannelResponse> response, Object userState) {
                mView.stopAll();
                mView.getPayTradeChannel(response);
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastLong(null != error.getDetail() ? error.getDetail() : "" + null != error.getMessage() ? error.getMessage() : "");
            }
        }, 3));
    }

    /**
     * 订单支付申请，表示向服务器请求支付参数，获取支付参数后根据不同的支付通道调用相应的第三方支付组件进行支付
     */
    public void orderPayApply(OrderPayApplyRequest request, final String payType) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.orderPayApply(request, new IAsyncResultCallback<OrderPayApplyResponse>() {
            @Override
            public void onComplete(OrderPayApplyResponse response, Object userState) {
                mView.orderPayApply(response, payType);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastLong(null != error.getDetail() ? error.getDetail() : "" + null != error.getMessage() ? error.getMessage() : "");
            }
        }, 3));
    }
}
