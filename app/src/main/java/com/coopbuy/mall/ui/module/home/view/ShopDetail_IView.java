package com.coopbuy.mall.ui.module.home.view;

import com.coopbuy.mall.api.reponse.ShopDetailResponse;
import com.coopbuy.mall.base.BaseView;

public interface ShopDetail_IView extends BaseView {
    void setShopDetailData(ShopDetailResponse shopDetailResponse);
    void addShopFavoriteSuccess();
    void removeShopFavoriteSuccess();
}
