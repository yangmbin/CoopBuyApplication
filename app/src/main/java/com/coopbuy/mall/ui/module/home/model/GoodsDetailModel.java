package com.coopbuy.mall.ui.module.home.model;

import com.coopbuy.mall.api.reponse.DescriptionResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.request.DescriptionRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class GoodsDetailModel implements BaseModel {
    public IAsyncRequestState getSkuDetailData(SkuDetailRequest request, IAsyncResultCallback<SkuDetailResponse> callback, Object userState) {
        return client.getSkuDetailData(request, callback, userState);
    }

    public IAsyncRequestState getDescriptionData(DescriptionRequest request, IAsyncResultCallback<DescriptionResponse> callback, Object userState) {
        return client.getDescriptionData(request, callback, userState);
    }
}
