package com.coopbuy.mall.ui.module.center.presenter;


import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.api.request.OrderListRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.fragment.AllOrderFragment;
import com.coopbuy.mall.ui.module.center.fragment.WaitPayOrderFragment;
import com.coopbuy.mall.ui.module.center.fragment.WaitReceiveOrderFragment;
import com.coopbuy.mall.ui.module.center.fragment.WaitSendOrderFragment;
import com.coopbuy.mall.ui.module.center.model.OrderModel;
import com.coopbuy.mall.ui.module.center.view.Order_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

public class OrderPresenter extends BasePresenter<Order_IView, OrderModel> {

    public static final int LOAD_TYPE_1 = 1; // 普通加载
    public static final int LOAD_TYPE_2 = 2; // 下拉刷新
    public static final int LOAD_TYPE_3 = 3; // 上拉加载

    public static final int ORDER_STATUS_ALL = 0; // 全部
    public static final int ORDER_STATUS_WAIT_PAY = 1; // 待支付
    public static final int ORDER_STATUS_WAIT_SEND = 2; // 待发货
    public static final int ORDER_STATUS_WAIT_RECEIVE = 3; // 待收货

    private AllOrderFragment mAllOrderFragment = null;
    private WaitPayOrderFragment mWaitPayOrderFragment = null;
    private WaitSendOrderFragment mWaitSendOrderFragment = null;
    private WaitReceiveOrderFragment mWaitReceiveOrderFragment = null;

    public OrderPresenter(Context context, OrderModel model, AllOrderFragment view) {
        super(context, model, view);
        mAllOrderFragment = view;
    }

    public OrderPresenter(Context context, OrderModel model, WaitPayOrderFragment view) {
        super(context, model, view);
        mWaitPayOrderFragment = view;
    }

    public OrderPresenter(Context context, OrderModel model, WaitSendOrderFragment view) {
        super(context, model, view);
        mWaitSendOrderFragment = view;
    }

    public OrderPresenter(Context context, OrderModel model, WaitReceiveOrderFragment view) {
        super(context, model, view);
        mWaitReceiveOrderFragment = view;
    }

    /**
     * 获取订单列表
     * @param orderStatus
     * @param pageNo
     * @param loadType
     */
    public void getOrderList(int orderStatus, int pageNo, final int loadType) {
        if (loadType == LOAD_TYPE_1)
            mView.showFillLoading();
        OrderListRequest request = new OrderListRequest();
        request.setStatus(orderStatus);
        request.setCurrentPage(pageNo);
        mView.appendNetCall(mModel.getOrderList(request, new IAsyncResultCallback<OrderListResponse>() {
            @Override
            public void onComplete(OrderListResponse orderListResponse, Object userState) {
                // 无数据显示
                if (loadType == OrderPresenter.LOAD_TYPE_1 && orderListResponse.getTotalCount() == 0) {
                    mView.showCustomLayout(R.layout.loadingbox_custom_no_order);
                    return;
                }
                mView.setOrderListData(orderListResponse, loadType);
                mView.stopAll();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();

            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
                else
                    mView.stopAll();

                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE) {
                    if (loadType == LOAD_TYPE_1)
                        mView.showNetOffLayout();
                    ToastUtils.toastShort(R.string.no_network);
                } else {
                    if (loadType == LOAD_TYPE_1)
                        mView.showNetErrorLayout();
                    ToastUtils.toastShort(R.string.connect_server_error);
                }
            }
        }, "订单列表"));
    }

    /**
     * 删除订单
     * @param orderId
     */
    public void deleteOrder(String orderId) {
        mView.showTransLoading();
        OrderIdRequest request = new OrderIdRequest();
        request.setOrderId(orderId);
        mView.appendNetCall(mModel.deleteOrder(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mAllOrderFragment.deleteOrderSuccess();
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
     * @param orderId
     */
    public void cancelOrder(String orderId) {
        mView.showTransLoading();
        OrderIdRequest request = new OrderIdRequest();
        request.setOrderId(orderId);
        mView.appendNetCall(mModel.cancelOrder(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                if (mAllOrderFragment != null)
                    mAllOrderFragment.cancelOrderSuccess();
                else
                    mWaitPayOrderFragment.cancelOrderSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "取消订单"));
    }

}
