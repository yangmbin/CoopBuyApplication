package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.GoodsUpdateResponse;
import com.coopbuy.mall.api.reponse.ShopCartResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.GoodsDeleteRequest;
import com.coopbuy.mall.api.request.GoodsUpdateRequest;
import com.coopbuy.mall.api.request.ProductIdRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * Created by niu on 2017/10/24.
 */

public class ShopCartModel implements BaseModel {
    public IAsyncRequestState getShopCartData(IAsyncResultCallback<ShopCartResponse> callback, Object userState) {
        return client.getShopCartData(callback, userState);
    }

    public IAsyncRequestState updateAddOrSubSkuinfo(GoodsUpdateRequest request, IAsyncResultCallback<GoodsUpdateResponse> callback, Object userState) {
        return client.updateAddOrSubSkuinfo(request, callback, userState);
    }
    public IAsyncRequestState deleteGoods(GoodsDeleteRequest request, IAsyncResultCallback<GoodsUpdateResponse> callback, Object userState) {
        return client.deleteGoods(request, callback, userState);
    }
    public IAsyncRequestState getSkuInfoListData(ProductIdRequest request, IAsyncResultCallback<List<SkuInfoResponse>> callback, Object userState) {
        return client.getSkuInfoListData(request, callback, userState);
    }
    public IAsyncRequestState findSkuInfoData(FindSkuInfoRequest request, IAsyncResultCallback<SkuDetailResponse.SkuInfoBean> callback, Object userState) {
        return client.findSkuInfoData(request, callback, userState);
    }
}
