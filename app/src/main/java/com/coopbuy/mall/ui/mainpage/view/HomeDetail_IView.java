package com.coopbuy.mall.ui.mainpage.view;

import com.coopbuy.mall.api.reponse.HomeDetailFloorResponse;
import com.coopbuy.mall.base.BaseView;

public interface HomeDetail_IView extends BaseView {
    void setHomeDetailData(HomeDetailFloorResponse homeDetailFloorResponse);
    void stopPullToRefreshLoading();
}
