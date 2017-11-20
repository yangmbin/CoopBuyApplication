package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.PayOtherResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public interface PayOther_IView extends BaseView {
    void getData(PayOtherResponse bean, String type);
}
