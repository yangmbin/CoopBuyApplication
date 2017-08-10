package com.coopbuy.mall.ui.module.home.view;

import com.coopbuy.mall.api.login.HomePageDataByIdResponse;
import com.coopbuy.mall.base.BaseView;

public interface BannerDetail_IView extends BaseView {
    void setBannerDetailData(HomePageDataByIdResponse homePageDataByIdResponse);
}
