package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.BeforeApplyRefundResponse;
import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * @author ymb
 * Create at 2017/10/24 20:29
 */
public interface ApplyRefund_IView extends BaseView {
    void uploadImageSuccess(UploadImageResponse uploadImageResponse, String localPath);
    void setBeforeApplyRefundData(BeforeApplyRefundResponse beforeApplyRefundResponse);
    void submitApplyRefundSuccess();
}
