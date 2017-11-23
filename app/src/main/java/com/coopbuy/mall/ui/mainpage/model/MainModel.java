package com.coopbuy.mall.ui.mainpage.model;

import com.coopbuy.mall.api.reponse.CheckUpdateResponse;
import com.coopbuy.mall.api.request.CheckUpdateRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class MainModel implements BaseModel {
    public IAsyncRequestState checkUpdate(CheckUpdateRequest request, IAsyncResultCallback<CheckUpdateResponse> callback, Object userState) {
        return client.checkUpdate(request, callback, userState);
    }
}
