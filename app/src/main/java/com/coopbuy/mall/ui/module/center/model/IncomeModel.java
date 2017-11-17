package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.InComeReponse;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public class IncomeModel implements BaseModel {
    public IAsyncRequestState getInComeData(CurrentPageRequest request, IAsyncResultCallback<InComeReponse> callback, Object userState) {
        return client.getInComeData (request,callback, userState);
    }
}
