package com.coopbuy.mall.ui.module.home.view;

import com.coopbuy.mall.api.reponse.HomePageDataByIdResponse;
import com.coopbuy.mall.base.BaseView;

public interface BannerDetail_IView extends BaseView {
    void setBannerDetailData(HomePageDataByIdResponse homePageDataByIdResponse);
    void stopPullToRefreshLoading();
}
