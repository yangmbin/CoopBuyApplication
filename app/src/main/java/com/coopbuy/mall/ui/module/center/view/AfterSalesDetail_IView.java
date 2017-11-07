package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.AfterSalesDetailResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * @author yangmbin
 * Create at 2017/11/2 10:43
 */
public interface AfterSalesDetail_IView extends BaseView {
    void setAfterSalesDetail(AfterSalesDetailResponse afterSalesDetailResponse);
    void cancelApplySuccess();
}
