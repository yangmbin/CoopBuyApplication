package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.ChangeAndForgetPwdResponse;
import com.coopbuy.mall.api.reponse.RegisterResponse;
import com.coopbuy.mall.api.request.ChangeAndForgetPwdRequest;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.SetPasswordModel;
import com.coopbuy.mall.ui.module.center.view.SetPassword_IView;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * @author csn
 * @date 2017/10/16 0016 17:56
 * @content
 */
public class SetPasswordPresenter extends BasePresenter<SetPassword_IView, SetPasswordModel> {
    public SetPasswordPresenter(Context mContext, SetPasswordModel mModel, SetPassword_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 注册
     *
     * @param request
     */
    public void register(RegisterRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.register(request, new IAsyncResultCallback<RegisterResponse>() {
            @Override
            public void onComplete(RegisterResponse smsCodeReponse, Object userState) {
                if (smsCodeReponse.isIsRegistered()) {
                    mView.registerSuccess();
                    ToastUtils.toastShort("注册成功");
                } else {
                    ToastUtils.toastShort(smsCodeReponse.getMessage());
                }
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "register"));
    }

    /**
     * 修改 和找回成功
     *
     * @param request
     */
    public void updatePwd(ChangeAndForgetPwdRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.updatePwd(request, new IAsyncResultCallback<ChangeAndForgetPwdResponse>() {
            @Override
            public void onComplete(ChangeAndForgetPwdResponse smsCodeReponse, Object userState) {
                if (smsCodeReponse.isSucceeded()) {
                    mView.registerSuccess();
                    ToastUtils.toastShort("设置成功");
                }
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "updatepwd"));
    }
}
