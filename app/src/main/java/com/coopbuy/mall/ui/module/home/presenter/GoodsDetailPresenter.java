package com.coopbuy.mall.ui.module.home.presenter;


import android.content.Context;

import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.home.model.GoodsDetailModel;
import com.coopbuy.mall.ui.module.home.view.GoodsDetail_IView;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

public class GoodsDetailPresenter extends BasePresenter<GoodsDetail_IView, GoodsDetailModel> {

    public GoodsDetailPresenter(Context context, GoodsDetailModel model, GoodsDetail_IView view) {
        super(context, model, view);
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
                    // mView.setSkuDetailData(skuDetailResponse);
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

}
