package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author csn
 * @date 2017/10/17 0017 14:28
 * @content
 */
public class CenterModel implements BaseModel {
    public IAsyncRequestState getUserInfo(IAsyncResultCallback<UserCenterInfoResponse> callback, Object userState) {
        return client.getUserInfo( callback, userState);
    }
}
