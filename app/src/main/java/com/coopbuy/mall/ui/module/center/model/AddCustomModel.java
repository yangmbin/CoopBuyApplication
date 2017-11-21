package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.MyCustomReponse;
import com.coopbuy.mall.api.request.AddUpdateCustomRequest;
import com.coopbuy.mall.api.request.MyCustomRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public class AddCustomModel implements BaseModel {
    public IAsyncRequestState addCustom(AddUpdateCustomRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.addCustom(request, callback, userState);
    }

    public IAsyncRequestState updateCustom(AddUpdateCustomRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.updateCustom(request, callback, userState);
    }
}
