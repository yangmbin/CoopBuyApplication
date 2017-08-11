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
    public OrderPresenter(Context context, OrderModel model, Order_IView view) {
        super(context, model, view);
    }

    /**
     * 获取全部订单
     * @param pageNo
     */
    public void getAllOrder(int pageNo) {
        mView.showFillLoading();
        GetOrderListRequest getOrderListRequest = new GetOrderListRequest();
        getOrderListRequest.setCurrentPage(pageNo);
        mModel.getOrderAllList(getOrderListRequest, new IAsyncResultCallback<GetOrderListResponse>() {
            @Override
            public void onComplete(GetOrderListResponse orderAllListResponse, Object userState) {
                mView.setAllOrderData(orderAllListResponse);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.showNetErrorLayout();
            }
        }, "allOrderList");
    }
}
