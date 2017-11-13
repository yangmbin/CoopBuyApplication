package com.coopbuy.mall.ui.module.center.presenter;


import android.content.Context;

import com.coopbuy.mall.api.reponse.OrderDetailResponse;
import com.coopbuy.mall.api.request.AddToCartRequest;
import com.coopbuy.mall.api.request.OrderDetailRequest;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.OrderDetailModel;
import com.coopbuy.mall.ui.module.center.view.OrderDetail_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
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

    /**
     * 删除订单
     *
     * @param orderId
     */
    public void deleteOrder(String orderId) {
        mView.showTransLoading();
        OrderIdRequest request = new OrderIdRequest();
        request.setOrderId(orderId);
        mView.appendNetCall(mModel.deleteOrder(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.deleteOrderSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "删除订单"));
    }

    /**
     * 取消订单
     *
     * @param orderId
     */
    public void cancelOrder(String orderId) {
        mView.showTransLoading();
        OrderIdRequest request = new OrderIdRequest();
        request.setOrderId(orderId);
        mView.appendNetCall(mModel.cancelOrder(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.cancelOrderSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "取消订单"));
    }

    /**
     * 延长收货
     *
     * @param orderId
     */
    public void delayedReceipt(String orderId) {
        mView.showTransLoading();
        OrderIdRequest request = new OrderIdRequest();
        request.setOrderId(orderId);
        mView.appendNetCall(mModel.delayedReceipt(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.delayedReceiptSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "延长收货"));
    }

    /**
     * 确认收货
     *
     * @param orderId
     */
    public void receipt(String orderId) {
        mView.showTransLoading();
        OrderIdRequest request = new OrderIdRequest();
        request.setOrderId(orderId);
        mView.appendNetCall(mModel.receipt(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.receiptSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "确认收货"));
    }

    /**
     * 提醒商家发货
     *
     * @param orderId
     */
    public void remindShipment(String orderId) {
        mView.showTransLoading();
        OrderIdRequest request = new OrderIdRequest();
        request.setOrderId(orderId);
        mView.appendNetCall(mModel.remindShipment(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.remindShipmentSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "提醒商家发货"));
    }


    /**
     * 再来一单
     * @param request
     */
    public void repeatSubmitOrder(final AddToCartRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.addToCart(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.repeatSubmitOrderSuccess(request);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "再来一单"));
    }
}
