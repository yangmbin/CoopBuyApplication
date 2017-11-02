package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.AfterSalesResponse;
import com.coopbuy.mall.api.request.PageRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author yangmbin
 * Create at 2017/11/2 10:43
 */
public class AfterSalesModel implements BaseModel {
    public IAsyncRequestState getAfterSalesList(PageRequest request, IAsyncResultCallback<AfterSalesResponse> callback, Object userState) {
        return client.getAfterSalesList(request, callback, userState);
    }
}
