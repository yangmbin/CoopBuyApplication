package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.AfterSalesDetailResponse;
import com.coopbuy.mall.api.request.AfterSalesDetailRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author yangmbin
 * Create at 2017/11/2 10:43
 */
public class AfterSalesDetailModel implements BaseModel {
    public IAsyncRequestState getAfterSalesDetail(AfterSalesDetailRequest request, IAsyncResultCallback<AfterSalesDetailResponse> callback, Object userState) {
        return client.getAfterSalesDetail(request, callback, userState);
    }
}
