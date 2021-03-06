package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.base.BaseView;

/**
 * @author csn
 * @date 2017/10/13 0013 14:20
 * @content
 */
public interface Login_IView extends BaseView {
    void loginSuccess();

    /**
     * @param msg
     * @param isNeedCode 是否需要验证码
     */
    void loginFail(String msg, boolean isNeedCode);

    void getImageCode(String code);
}
