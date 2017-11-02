package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.OrderBuildResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/10/26- 14:02
 */

public interface OrderBuild_IView extends BaseView {

    void getOrderBuildData(OrderBuildResponse data);

    void fail();

    void orderSubmitSuccess(String orderid);
}
