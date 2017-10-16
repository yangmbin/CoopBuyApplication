package com.coopbuy.mall.ui.mainpage.view;

import com.coopbuy.mall.api.reponse.HomePageDataResponse;
import com.coopbuy.mall.base.BaseView;

public interface Home_IView extends BaseView {
    void setHomeData(HomePageDataResponse homePageDataResponse);
    void stopPullToRefreshLoading();
}
