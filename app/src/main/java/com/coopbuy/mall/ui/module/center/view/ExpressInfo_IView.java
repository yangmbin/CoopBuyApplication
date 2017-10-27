package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.ExpressInfoResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * @author yangmbin
 * Create at 2017/10/27 16:52
 */
public interface ExpressInfo_IView extends BaseView {
    void setExpressInfo(ExpressInfoResponse expressInfoResponse);
}
