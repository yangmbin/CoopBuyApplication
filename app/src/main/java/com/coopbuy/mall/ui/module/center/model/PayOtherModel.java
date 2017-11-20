package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.PayOtherResponse;
import com.coopbuy.mall.api.reponse.SMSCodeReponse;
import com.coopbuy.mall.api.request.AddUpdateCustomRequest;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public class PayOtherModel implements BaseModel {
    public IAsyncRequestState getData(CurrentPageRequest request, IAsyncResultCallback<PayOtherResponse> callback, Object userState) {
        return client.getPayOnther(request, callback, userState);
    }


}
