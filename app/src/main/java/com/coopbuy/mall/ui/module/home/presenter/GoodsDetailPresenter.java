package com.coopbuy.mall.ui.module.home.presenter;


import android.content.Context;

import com.coopbuy.mall.api.reponse.DescriptionResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.request.DescriptionRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_1;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_2;
import com.coopbuy.mall.ui.module.home.model.GoodsDetailModel;
import com.coopbuy.mall.ui.module.home.view.GoodsDetail_IView;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

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
                    mView.stopAll();
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
     * 获取商品描述
     * @param productId
     */
    public void getDescriptionData(int productId) {
        DescriptionRequest request = new DescriptionRequest();
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
}
