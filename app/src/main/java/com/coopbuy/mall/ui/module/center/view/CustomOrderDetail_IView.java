package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.CustomOrderDetailReponse;
import com.coopbuy.mall.api.reponse.CustomOrderReponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public interface CustomOrderDetail_IView extends BaseView {

    void getData(CustomOrderDetailReponse bean);
}
