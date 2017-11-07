package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.ShippingCompanyResponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

/**
 * @author yangmbin
 * Create at 2017/10/27 16:52
 */
public interface BuyerSendGoods_IView extends BaseView {
    void setShippingCompanyList(List<ShippingCompanyResponse> shippingCompanyResponseList);
    void sendGoodsSuccess();
}
