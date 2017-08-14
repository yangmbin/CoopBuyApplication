package com.coopbuy.mall.ui.module.center.presenter;


import android.content.Context;

import com.coopbuy.mall.api.login.GetOrderListRequest;
import com.coopbuy.mall.api.login.GetOrderListResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.OrderModel;
import com.coopbuy.mall.ui.module.center.view.Order_IView;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

public class OrderPresenter extends BasePresenter<Order_IView, OrderModel> {

    public static final int LOAD_TYPE_1 = 1; // 普通加载
    public static final int LOAD_TYPE_2 = 2; // 下拉刷新
    public static final int LOAD_TYPE_3 = 3; // 上拉加载

    public OrderPresenter(Context context, OrderModel model, Order_IView view) {
        super(context, model, view);
    }

    /**
     * 获取全部订单
     * @param pageNo
     */
    public void getAllOrder(int pageNo, final int loadType) {
        if (loadType == LOAD_TYPE_1)
            mView.showFillLoading();
        GetOrderListRequest getOrderListRequest = new GetOrderListRequest();
        getOrderListRequest.setCurrentPage(pageNo);
        mModel.getOrderAllList(getOrderListRequest, new IAsyncResultCallback<GetOrderListResponse>() {
            @Override
            public void onComplete(GetOrderListResponse orderListResponse, Object userState) {
                // 无数据显示
                if (loadType == OrderPresenter.LOAD_TYPE_1 && orderListResponse.getRowCount() == 0) {
                    mView.showNoDataLayout();
                    return;
                }
                mView.setOrderData(orderListResponse, loadType);
                mView.stopAll();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();

            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.showNetErrorLayout();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }
        }, "allOrderList");
    }


    /**
     * 获取待付款订单
     * @param pageNo
     */
    public void getWaitPayOrder(int pageNo, final int loadType) {
        if (loadType == LOAD_TYPE_1)
            mView.showFillLoading();
        GetOrderListRequest getOrderListRequest = new GetOrderListRequest();
        getOrderListRequest.setCurrentPage(pageNo);
        mModel.getOrderListWaitForPayment(getOrderListRequest, new IAsyncResultCallback<GetOrderListResponse>() {
            @Override
            public void onComplete(GetOrderListResponse orderListResponse, Object userState) {
                // 无数据显示
                if (loadType == OrderPresenter.LOAD_TYPE_1 && orderListResponse.getRowCount() == 0) {
                    mView.showNoDataLayout();
                    return;
                }
                mView.setOrderData(orderListResponse, loadType);
                mView.stopAll();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.showNetErrorLayout();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }
        }, "waitPayOrderList");
    }


    /**
     * 获取待发货订单
     * @param pageNo
     */
    public void getWaitSendOrder(int pageNo, final int loadType) {
        if (loadType == LOAD_TYPE_1)
            mView.showFillLoading();
        GetOrderListRequest getOrderListRequest = new GetOrderListRequest();
        getOrderListRequest.setCurrentPage(pageNo);
        mModel.getOrderListWaitForDispatch(getOrderListRequest, new IAsyncResultCallback<GetOrderListResponse>() {
            @Override
            public void onComplete(GetOrderListResponse orderListResponse, Object userState) {
                // 无数据显示
                if (loadType == OrderPresenter.LOAD_TYPE_1 && orderListResponse.getRowCount() == 0) {
                    mView.showNoDataLayout();
                    return;
                }
                mView.setOrderData(orderListResponse, loadType);
                mView.stopAll();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.showNetErrorLayout();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }
        }, "waitSendOrderList");
    }


    /**
     * 获取待收货订单
     * @param pageNo
     */
    public void getWaitReceiveOrder(int pageNo, final int loadType) {
        if (loadType == LOAD_TYPE_1)
            mView.showFillLoading();
        GetOrderListRequest getOrderListRequest = new GetOrderListRequest();
        getOrderListRequest.setCurrentPage(pageNo);
        mModel.getOrderListWaitForReceive(getOrderListRequest, new IAsyncResultCallback<GetOrderListResponse>() {
            @Override
            public void onComplete(GetOrderListResponse orderListResponse, Object userState) {
                // 无数据显示
                if (loadType == OrderPresenter.LOAD_TYPE_1 && orderListResponse.getRowCount() == 0) {
                    mView.showNoDataLayout();
                    return;
                }
                mView.setOrderData(orderListResponse, loadType);
                mView.stopAll();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.showNetErrorLayout();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }
        }, "waitReceiveOrderList");
    }


    /**
     * 获取待评价订单
     * @param pageNo
     */
    public void getWaitCommentOrder(int pageNo, final int loadType) {
        if (loadType == LOAD_TYPE_1)
            mView.showFillLoading();
        GetOrderListRequest getOrderListRequest = new GetOrderListRequest();
        getOrderListRequest.setCurrentPage(pageNo);
        mModel.getOrderListWaitForComment(getOrderListRequest, new IAsyncResultCallback<GetOrderListResponse>() {
            @Override
            public void onComplete(GetOrderListResponse orderListResponse, Object userState) {
                // 无数据显示
                if (loadType == OrderPresenter.LOAD_TYPE_1 && orderListResponse.getRowCount() == 0) {
                    mView.showNoDataLayout();
                    return;
                }
                mView.setOrderData(orderListResponse, loadType);
                mView.stopAll();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.showNetErrorLayout();
                if (loadType != LOAD_TYPE_1)
                    mView.stopRefreshLayoutLoading();
            }
        }, "waitCommentOrderList");
    }
}
