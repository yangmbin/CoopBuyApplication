package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.ChangeAndForgetPwdResponse;
import com.coopbuy.mall.api.reponse.RegisterResponse;
import com.coopbuy.mall.api.reponse.SMSCodeReponse;
import com.coopbuy.mall.api.request.ChangeAndForgetPwdRequest;
import com.coopbuy.mall.api.request.ImageCodeRequest;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author csn
 * @date 2017/10/16 0016 14:46
 * @content
 */
public class RegisterModel implements BaseModel {
    public IAsyncRequestState getSMS(ImageCodeRequest request, IAsyncResultCallback<SMSCodeReponse> callback, Object userState) {
        return client.getSMSCode(request, callback, userState);
    }
    public IAsyncRequestState getSMSUpdatae(ImageCodeRequest request, IAsyncResultCallback<SMSCodeReponse> callback, Object userState) {
        return client.getSMSCodeUpdate(request, callback, userState);
    }


}
