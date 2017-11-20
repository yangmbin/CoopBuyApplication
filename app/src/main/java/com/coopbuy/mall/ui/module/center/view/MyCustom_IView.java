package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.MyBillReponse;
import com.coopbuy.mall.api.reponse.MyCustomReponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public interface MyCustom_IView extends BaseView {

    void getData(MyCustomReponse bean, String type);
}
