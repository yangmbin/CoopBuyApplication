package com.coopbuy.mall.ui.module.test.model;

import com.coopbuy.mall.api.login.HomePageDataRequest;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.api.login.ImageCodeRequest;
import com.coopbuy.mall.api.login.ImageCodeResponse;
import com.coopbuy.mall.api.login.LoginClient;
import com.coopbuy.mall.api.login.LoginQuitRespsonse;
import com.coopbuy.mall.api.login.LoginRequest;
import com.coopbuy.mall.api.login.LoginResponse;
import com.coopbuy.mall.api.login.RegisterRequest;
import com.coopbuy.mall.api.login.RegisterResponse;
import com.coopbuy.mall.api.login.SendSmsCodeRequest;
import com.coopbuy.mall.api.login.SendSmsCodeResponse;
import com.coopbuy.mall.api.login.SmsResetPasswordGetCodeRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordGetCodeResponse;
import com.coopbuy.mall.api.login.SmsResetPasswordRequest;
import com.coopbuy.mall.api.login.SmsResetPasswordResponse;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

/**
 * @author csn
 * @date 2017/8/2 0002 17:09
 * @content
 */
public class NiuTestModel implements BaseModel {
    LoginClient client = new LoginClient();

    public void login(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        client.LoginRequest(request, callback, userState);
    }

    public void getImageCode(ImageCodeRequest request, IAsyncResultCallback<ImageCodeResponse> callback, Object userState) {
        client.getImageCode(request, callback, userState);
    }

    public void sendSmsCode(SendSmsCodeRequest request, IAsyncResultCallback<SendSmsCodeResponse> callback, Object userState) {
        client.senSmsCode(request, callback, userState);

    }

    public void smsResetPasswordGetCode(SmsResetPasswordGetCodeRequest request, IAsyncResultCallback<SmsResetPasswordGetCodeResponse> callback, Object userState) {
        client.smsResetPasswordGetCode(request, callback, userState);
    }

    public void smsResetPassword(SmsResetPasswordRequest request, IAsyncResultCallback<SmsResetPasswordResponse> callback, Object userState) {
        client.smsResetPassword(request, callback, userState);
    }

    public void registerUser(RegisterRequest request, IAsyncResultCallback<RegisterResponse> callback, Object userState) {
        client.register(request, callback, userState);
    }

    public void loginQuit(IAsyncResultCallback<LoginQuitRespsonse> callback, Object userState) {
        client.quitUser(callback, userState);
    }
      public void homePageData(HomePageDataRequest request, IAsyncResultCallback<HomePageDataResponse> callback, Object userState) {
        client.homePageData(request,callback, userState);
    }



}
