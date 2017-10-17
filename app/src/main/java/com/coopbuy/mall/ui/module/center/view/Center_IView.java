package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * @author csn
 * @date 2017/10/17 0017 14:29
 * @content
 */
public interface Center_IView extends BaseView {

    void getUserData(UserCenterInfoResponse data);
}
