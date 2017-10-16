package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.LoginResponse;
import com.coopbuy.mall.api.request.LoginRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.LoginModel;
import com.coopbuy.mall.ui.module.center.view.Login_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * @author csn
 * @date 2017/10/13 0013 14:19
 * @content
 */
public class LoginPresenter extends BasePresenter<Login_IView, LoginModel> {
    public LoginPresenter(Context mContext, LoginModel mModel, Login_IView mView) {
        super(mContext, mModel, mView);
    }

    public void login(LoginRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.login(request, new IAsyncResultCallback<LoginResponse>() {
            @Override
            public void onComplete(LoginResponse loginResponse, Object userState) {
                if (loginResponse != null) {
                    if (loginResponse.isSuccess()) {
                        mView.loginSuccess();
                        ToastUtils.toastShort("登录成功");
                    } else {
                        mView.loginFail(loginResponse.getMessage());
                        ToastUtils.toastShort(loginResponse.getMessage());
                    }
                    mView.stopAll();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    error.getDetail();
                    mView.loginFail(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "login"));
    }
}
