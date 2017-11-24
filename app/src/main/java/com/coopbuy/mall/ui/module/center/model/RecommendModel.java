package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.RecommendResponse;
import com.coopbuy.mall.api.request.SetDefaultOrDeleteOrFindAddressRequest;
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
public class RecommendModel implements BaseModel {

    public IAsyncRequestState getData(IAsyncResultCallback<List<RecommendResponse>> callback, Object userState) {
        return client.getRecommendData(callback, userState);
    }
}
