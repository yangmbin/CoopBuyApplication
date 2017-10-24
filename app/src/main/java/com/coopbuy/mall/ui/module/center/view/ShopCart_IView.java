package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.ShopCartReponse;
import com.coopbuy.mall.base.BaseView;

/**
 * @author niu
 * @time 2017/10/24 10:29
 * @content
 */
public interface ShopCart_IView extends BaseView {
    void getShopCartData(ShopCartReponse data);
}
