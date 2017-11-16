package com.coopbuy.mall.ui.module.home.model;

import com.coopbuy.mall.api.reponse.CalculateFreightResponse;
import com.coopbuy.mall.api.reponse.DefaultAddressResponse;
import com.coopbuy.mall.api.reponse.DescriptionResponse;
import com.coopbuy.mall.api.reponse.GetCartQuantityResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.request.AddToCartRequest;
import com.coopbuy.mall.api.request.CalculateFreightRequest;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.ProductIdRequest;
import com.coopbuy.mall.api.request.ShopIdRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.api.request.SkuIdRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;


public class GoodsDetailModel implements BaseModel {
    public IAsyncRequestState getSkuDetailData(SkuDetailRequest request, IAsyncResultCallback<SkuDetailResponse> callback, Object userState) {
        return client.getSkuDetailData(request, callback, userState);
    }

    public IAsyncRequestState getDescriptionData(ProductIdRequest request, IAsyncResultCallback<DescriptionResponse> callback, Object userState) {
        return client.getDescriptionData(request, callback, userState);
    }

    public IAsyncRequestState getSkuInfoListData(ProductIdRequest request, IAsyncResultCallback<List<SkuInfoResponse>> callback, Object userState) {
        return client.getSkuInfoListData(request, callback, userState);
    }

    public IAsyncRequestState findSkuInfoData(FindSkuInfoRequest request, IAsyncResultCallback<SkuDetailResponse.SkuInfoBean> callback, Object userState) {
        return client.findSkuInfoData(request, callback, userState);
    }

    public IAsyncRequestState getDefaultAddressData(IAsyncResultCallback<DefaultAddressResponse> callback, Object userState) {
        return client.getDefaultAddressData(callback, userState);
    }

    public IAsyncRequestState calculateFreight(CalculateFreightRequest request, IAsyncResultCallback<CalculateFreightResponse> callback, Object userState) {
        return client.calculateFreight(request, callback, userState);
    }

    public IAsyncRequestState addToCart(AddToCartRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.addToCart(request, callback, userState);
    }

    public IAsyncRequestState addFavorite(SkuIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.addFavorite(request, callback, userState);
    }

    public IAsyncRequestState removeFavorite(SkuIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.removeFavorite(request, callback, userState);
    }

    public IAsyncRequestState getCartQuantity(IAsyncResultCallback<GetCartQuantityResponse> callback, Object userState) {
        return client.getCartQuantity(callback, userState);
    }

    public IAsyncRequestState addShopFavorite(ShopIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.addShopFavorite(request, callback, userState);
    }

    public IAsyncRequestState removeShopFavorite(ShopIdRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.removeShopFavorite(request, callback, userState);
    }
}
