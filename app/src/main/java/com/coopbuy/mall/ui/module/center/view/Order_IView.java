package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.GetOrderListResponse;
import com.coopbuy.mall.base.BaseView;

public interface Order_IView extends BaseView {
    void setOrderData(GetOrderListResponse orderListResponse, int loadType);
    void stopRefreshLayoutLoading();
}
