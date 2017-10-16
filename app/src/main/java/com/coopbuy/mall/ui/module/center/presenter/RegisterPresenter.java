package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;


import com.coopbuy.mall.api.reponse.SMSCodeReponse;
import com.coopbuy.mall.api.request.ImageCodeRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.RegisterModel;
import com.coopbuy.mall.ui.module.center.view.Register_IView;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * @author csn
 * @date 2017/10/16 0016 14:47
 * @content
 */
public class RegisterPresenter extends BasePresenter<Register_IView, RegisterModel> {
    public RegisterPresenter(Context mContext, RegisterModel mModel, Register_IView mView) {
        super(mContext, mModel, mView);
    }

    public void getSMSCode(String phone) {
        ImageCodeRequest request = new ImageCodeRequest();
        request.setPhone(phone);
        mView.appendNetCall(mModel.getSMS(request, new IAsyncResultCallback<SMSCodeReponse>() {
            @Override
            public void onComplete(SMSCodeReponse smsCodeReponse, Object userState) {

            }

            @Override
            public void onError(NetworkException error, Object userState) {

            }
        }, "sms"));

    }
}
