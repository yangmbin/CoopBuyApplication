package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.ChangeAndForgetPwdResponse;
import com.coopbuy.mall.api.reponse.RegisterResponse;
import com.coopbuy.mall.api.request.ChangeAndForgetPwdRequest;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author csn
 * @date 2017/10/16 0016 17:56
 * @content
 */
public class SetPasswordModel implements BaseModel {
    public IAsyncRequestState register(RegisterRequest request, IAsyncResultCallback<RegisterResponse> callback, Object userState) {
        return client.register(request, callback, userState);
    }

    public IAsyncRequestState updatePwd(ChangeAndForgetPwdRequest request, IAsyncResultCallback<ChangeAndForgetPwdResponse> callback, Object userState) {
        return client.updatePwd(request, callback, userState);
    }
}
