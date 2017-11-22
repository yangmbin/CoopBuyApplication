package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.SystemMegResponse;
import com.coopbuy.mall.api.request.MegRequest;
import com.coopbuy.mall.api.request.MessageReadRequest;
import com.coopbuy.mall.api.request.ShopSotreCancelRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/11/1- 9:48
 */

public class SystemMsgModel implements BaseModel {
    public IAsyncRequestState getData(MegRequest request, IAsyncResultCallback<SystemMegResponse> callback, Object userState) {
        return client.getSystemData(request, callback, userState);
    }

    public IAsyncRequestState sendOneRead(MessageReadRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.sendOneRead(request, callback, userState);
    }

    public IAsyncRequestState sendAllRead(MegRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.sendAllRead(request, callback, userState);
    }
}
