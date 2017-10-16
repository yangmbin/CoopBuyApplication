package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.request.ImageCodeRequest;
import com.coopbuy.mall.api.request.LoginRequest;
import com.coopbuy.mall.api.reponse.LoginResponse;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author csn
 * @date 2017/10/13 0013 14:19
 * @content
 */
public class LoginModel implements BaseModel {
    public IAsyncRequestState login(LoginRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return client.login(request, callback, userState);
    }

    public IAsyncRequestState imageCode(ImageCodeRequest request, IAsyncResultCallback<String> callback, Object userState) {
        return client.imageCode(request, callback, userState);
    }

}
