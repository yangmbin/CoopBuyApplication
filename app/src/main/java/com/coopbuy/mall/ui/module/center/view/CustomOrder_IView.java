package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.CustomOrderReponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public interface CustomOrder_IView extends BaseView {

    void getData(CustomOrderReponse bean,String type);
}
