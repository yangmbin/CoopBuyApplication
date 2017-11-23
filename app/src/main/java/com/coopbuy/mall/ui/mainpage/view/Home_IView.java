package com.coopbuy.mall.ui.mainpage.view;

import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

public interface Home_IView extends BaseView {
    void setHomeData(List<HomeFloorResponse> homeFloorResponseList);
    void stopPullToRefreshLoading();
}
