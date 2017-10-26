package com.coopbuy.mall.ui.module.center.presenter;


import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.api.request.OrderListRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.OrderModel;
import com.coopbuy.mall.ui.module.center.view.Order_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

public class OrderPresenter extends BasePresenter<Order_IView, OrderModel> {

    public static final int LOAD_TYPE_1 = 1; // 普通加载
    public static final int LOAD_TYPE_2 = 2; // 下拉刷新
    public static final int LOAD_TYPE_3 = 3; // 上拉加载

    public static final int ORDER_STATUS_ALL = 0; // 全部
    public static final int ORDER_STATUS_WAIT_PAY = 1; // 待支付
    public static final int ORDER_STATUS_WAIT_SEND = 2; // 待发货
    public static final int ORDER_STATUS_WAIT_RECEIVE = 3; // 待收货

    public OrderPresenter(Context context, OrderModel model, Order_IView view) {
        super(context, model, view);
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
}
