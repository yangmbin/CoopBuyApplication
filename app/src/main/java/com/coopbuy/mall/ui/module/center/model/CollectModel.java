package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.api.request.CollectRequest;
import com.coopbuy.mall.api.request.PublishProductRequest;
import com.coopbuy.mall.api.request.SetDefaultOrDeleteOrFindAddressRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/17 0017 20:14
 * @content
 */
public class CollectModel implements BaseModel {

    public IAsyncRequestState getCollectData(CollectRequest request,IAsyncResultCallback<CollectResponse> callback, Object userState) {
        return client.getCollectData (request,callback, userState);
    } public IAsyncRequestState getCollectData(SkuDetailRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.updateStatus (request,callback, userState);
    }
    public IAsyncRequestState publishProduct(PublishProductRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.publishProduct (request,callback, userState);
    } public IAsyncRequestState removeFovorite (SkuDetailRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.removeFovorite (request,callback, userState);
    }

}
