package com.coopbuy.mall.ui.module.home.presenter;


import android.content.Context;

import com.coopbuy.mall.api.reponse.ShopDetailResponse;
import com.coopbuy.mall.api.request.ShopIdRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.home.model.ShopDetailModel;
import com.coopbuy.mall.ui.module.home.view.ShopDetail_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

public class ShopDetailPresenter extends BasePresenter<ShopDetail_IView, ShopDetailModel> {

    public ShopDetailPresenter(Context context, ShopDetailModel model, ShopDetail_IView view) {
        super(context, model, view);
    }

    /**
     * 获取店铺详情
     * @param shopId
     */
    public void getShopDetail(int shopId) {
        mView.showFillLoading();
        ShopIdRequest request = new ShopIdRequest();
        request.setShopId(shopId);
        mView.appendNetCall(mModel.getShopDetail(request, new IAsyncResultCallback<ShopDetailResponse>() {
            @Override
            public void onComplete(ShopDetailResponse shopDetailResponse, Object userState) {
                mView.setShopDetailData(shopDetailResponse);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE)
                    mView.showNetOffLayout();
                else
                    mView.showNetErrorLayout();
            }
        }, "获取店铺详情"));

    }

    /**
     * 收藏店铺
     * @param shopId
     */
    public void addShopFavorite(int shopId) {
        mView.showTransLoading();
        ShopIdRequest request = new ShopIdRequest();
        request.setShopId(shopId);
        mView.appendNetCall(mModel.addShopFavorite(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.addShopFavoriteSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "收藏店铺"));
    }

    /**
     * 取消店铺收藏
     * @param shopId
     */
    public void removeShopFavorite(int shopId) {
        mView.showTransLoading();
        ShopIdRequest request = new ShopIdRequest();
        request.setShopId(shopId);
        mView.appendNetCall(mModel.addShopFavorite(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.removeShopFavoriteSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "取消店铺收藏"));
    }
}
