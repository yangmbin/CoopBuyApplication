package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.request.SuggestRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/10/31- 17:12
 */

public class SuggestModel implements BaseModel {
    public IAsyncRequestState suggestion(SuggestRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.suggestion(request, callback, userState);
    }
}
