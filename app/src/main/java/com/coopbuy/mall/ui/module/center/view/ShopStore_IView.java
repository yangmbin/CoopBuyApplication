package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.ShopStoreReponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/10/27- 16:46
 */

public interface ShopStore_IView  extends BaseView {
    void getShopStoreList(ShopStoreReponse reponse, String type);

    void shopStoreCancelSuccess(int postion);
}
