package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.ShippingCompanyResponse;
import com.coopbuy.mall.api.request.BuyerSendGoodsRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author yangmbin
 * Create at 2017/11/7 9:43
 */
public class BuyerSendGoodsModel implements BaseModel {
    public IAsyncRequestState getShippingCompanyList(IAsyncResultCallback<List<ShippingCompanyResponse>> callback, Object userState) {
        return client.getShippingCampanyList(callback, userState);
    }

    public IAsyncRequestState sendGoods(BuyerSendGoodsRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.sendGoods(request, callback, userState);
    }
}
