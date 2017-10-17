package com.coopbuy.mall.ui.module.center.presenter;


import android.content.Context;

import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.request.OrderDetailRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.OrderDetailModel;
import com.coopbuy.mall.ui.module.center.view.OrderDetail_IView;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

public class OrderDetailPresenter extends BasePresenter<OrderDetail_IView, OrderDetailModel> {

    public OrderDetailPresenter(Context context, OrderDetailModel model, OrderDetail_IView view) {
        super(context, model, view);
    }

    /**
     * 获取订单详情
     *
     * @param orderId
     */
    public void getOrderDetail(String orderId) {
        mView.showFillLoading();
        OrderDetailRequest orderDetail = new OrderDetailRequest();
        orderDetail.setOrderId(orderId);
        mView.appendNetCall(mModel.getOrderDetail(orderDetail, new IAsyncResultCallback<OrderDetailResponse>() {
            @Override
            public void onComplete(OrderDetailResponse orderDetailResponse, Object userState) {
                mView.setOrderDetailData(orderDetailResponse);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE) {
                    mView.showNetOffLayout();
                } else {
                    mView.showNetErrorLayout();
                }
            }
        }, "订单详情"));
    }
}
