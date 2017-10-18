package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.OrderListResponse;
import com.coopbuy.mall.base.BaseView;

public interface Order_IView extends BaseView {
    void setOrderListData(OrderListResponse orderListResponse, int loadType);
    void stopRefreshLayoutLoading();
}
