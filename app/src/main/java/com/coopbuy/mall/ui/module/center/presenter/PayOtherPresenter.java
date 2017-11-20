package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.PayOtherResponse;
import com.coopbuy.mall.api.reponse.SMSCodeReponse;
import com.coopbuy.mall.api.request.AddUpdateCustomRequest;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddCustomModel;
import com.coopbuy.mall.ui.module.center.model.PayOtherModel;
import com.coopbuy.mall.ui.module.center.view.AddCustom_IView;
import com.coopbuy.mall.ui.module.center.view.PayOther_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/17- 14:31
 */

public class PayOtherPresenter extends BasePresenter<PayOther_IView, PayOtherModel> {


    public PayOtherPresenter(Context mContext, PayOtherModel mModel, PayOther_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 添加客户
     *
     * @param request
     */
    public void getData(CurrentPageRequest request, final String type) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.getData(request, new IAsyncResultCallback<PayOtherResponse>() {
            @Override
            public void onComplete(PayOtherResponse response, Object userState) {
                mView.stopRefresh();
                if (response.getItems().isEmpty()) {
                    if (type.equals("more")) {
                        ToastUtils.toastShort("没有数据了");
                        mView.stopAll();
                    } else {
                        mView.showNoDataLayout();
                    }
                } else {
                    mView.getData(response, type);
                    mView.stopAll();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopRefresh();
                if (error != null) {
                    error.getDetail();
                    ToastUtils.toastShort(error.getMessage());
                }
                mView.stopAll();
            }
        }, "userinfo"));
    }

}
