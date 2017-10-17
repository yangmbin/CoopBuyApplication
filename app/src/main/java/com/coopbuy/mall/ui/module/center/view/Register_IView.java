package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.base.BaseView;

/**
 * @author csn
 * @date 2017/10/16 0016 14:47
 * @content
 */
public interface Register_IView extends BaseView {


    /**
     * 倒计时显示
     **/
    void onTimeTick(long time);

    /**
     * 倒计时完毕
     **/
    void onTimeFinish();

    void smsCode(String code);

}
