package com.coopbuy.mall.ui.module.home.presenter;


import android.content.Context;

import com.coopbuy.mall.api.reponse.CalculateFreightResponse;
import com.coopbuy.mall.api.reponse.DefaultAddressResponse;
import com.coopbuy.mall.api.reponse.DescriptionResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.request.CalculateFreightRequest;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.ProductIdRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_1;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_2;
import com.coopbuy.mall.ui.module.home.model.GoodsDetailModel;
import com.coopbuy.mall.ui.module.home.view.GoodsDetail_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

public class GoodsDetailPresenter extends BasePresenter<GoodsDetail_IView, GoodsDetailModel> {

    private GoodsDetailFragment_1 fragment_1;
    private GoodsDetailFragment_2 fragment_2;

    public GoodsDetailPresenter(Context context, GoodsDetailModel model, GoodsDetail_IView view) {
        super(context, model, view);
    }

    public GoodsDetailPresenter(Context context, GoodsDetailModel model, GoodsDetailFragment_1 view) {
        super(context, model, view);
        fragment_1 = view;
    }

    public GoodsDetailPresenter(Context context, GoodsDetailModel model, GoodsDetailFragment_2 view) {
        super(context, model, view);
        fragment_2 = view;
    }

    /**
     * 获取SKU详情
     * @param skuId
     */
    public void getSkuDetailData(int skuId) {
        mView.showFillLoading();
        SkuDetailRequest request = new SkuDetailRequest();
        request.setSkuId(skuId);
        mView.appendNetCall(mModel.getSkuDetailData(request, new IAsyncResultCallback<SkuDetailResponse>() {
            @Override
            public void onComplete(SkuDetailResponse skuDetailResponse, Object userState) {
                if (skuDetailResponse == null)
                    mView.showNoDataLayout();
                else {
                    fragment_1.setSkuDetailData(skuDetailResponse);
                    // 获取默认地址
                    getDefaultAddressData(skuDetailResponse);
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE)
                    mView.showNetOffLayout();
                else
                    mView.showNetErrorLayout();
            }
        }, "SKU详情"));
    }

    /**
     * 获取用户默认地址
     */
    public void getDefaultAddressData(final SkuDetailResponse skuDetailResponse) {
        mView.appendNetCall(mModel.getDefaultAddressData(new IAsyncResultCallback<DefaultAddressResponse>() {
            @Override
            public void onComplete(DefaultAddressResponse defaultAddressResponse, Object userState) {
                fragment_1.setDefaultAddressData(defaultAddressResponse);
                // 计算运费
                calculateFreight(defaultAddressResponse.getRegionId(), skuDetailResponse.getSkuInfo().getSkuId(), 1);
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
            }
        }, "获取用户默认地址"));
    }


    /**
     * 计算运费
     * @param regionId
     * @param skuId
     * @param quantity
     */
    public void calculateFreight(long regionId, int skuId, int quantity) {
        CalculateFreightRequest request = new CalculateFreightRequest();
        request.setRegionId(regionId);
        request.setSkuId(skuId);
        request.setQuantity(quantity);
        mView.appendNetCall(mModel.calculateFreight(request, new IAsyncResultCallback<CalculateFreightResponse>() {
            @Override
            public void onComplete(CalculateFreightResponse calculateFreightResponse, Object userState) {
                fragment_1.setFreightData(calculateFreightResponse);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
            }
        }, "计算运费"));
    }


    /**
     * 获取商品描述
     * @param productId
     */
    public void getDescriptionData(int productId) {
        ProductIdRequest request = new ProductIdRequest();
        request.setProductId(productId);
        mView.appendNetCall(mModel.getDescriptionData(request, new IAsyncResultCallback<DescriptionResponse>() {
            @Override
            public void onComplete(DescriptionResponse descriptionResponse, Object userState) {
                if (descriptionResponse != null)
                    fragment_2.setDescriptionData(descriptionResponse);
            }

            @Override
            public void onError(NetworkException error, Object userState) {

            }
        }, "商品描述"));
    }


    /**
     * 获取商品Sku信息列表
     * @param productId
     */
    public void getSkuInfoListData(int productId) {
        mView.showTransLoading();
        ProductIdRequest request = new ProductIdRequest();
        request.setProductId(productId);
        mView.appendNetCall(mModel.getSkuInfoListData(request, new IAsyncResultCallback<List<SkuInfoResponse>>() {
            @Override
            public void onComplete(List<SkuInfoResponse> skuInfoResponses, Object userState) {
                mView.stopAll();
                fragment_1.setSkuInfoListData(skuInfoResponses);
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "商品Sku列表"));
    }


    /**
     * 获取指定规格值或属性值的sku信息
     * @param request
     */
    public void findSkuInfoData(FindSkuInfoRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.findSkuInfoData(request, new IAsyncResultCallback<SkuDetailResponse.SkuInfoBean>() {
            @Override
            public void onComplete(SkuDetailResponse.SkuInfoBean skuInfoBean, Object userState) {
                fragment_1.setFindSkuInfoData(skuInfoBean);
                // 规格改变后，重新计算运费
                if (fragment_1.getCurrentRegionId() != -1 && fragment_1.getCurrentSkuId() != -1)
                    calculateFreight(fragment_1.getCurrentRegionId(), fragment_1.getCurrentSkuId(), fragment_1.getCurrentQuantity());
                else
                    mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "获取指定规格值或属性值的sku信息"));
    }
}
