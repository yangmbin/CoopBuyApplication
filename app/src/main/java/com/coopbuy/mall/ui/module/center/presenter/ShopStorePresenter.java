package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.ShopStoreReponse;
import com.coopbuy.mall.api.request.ShopSotreCancelRequest;
import com.coopbuy.mall.api.request.ShopCurrentPageRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.ShopStoreModel;
import com.coopbuy.mall.ui.module.center.view.ShopStore_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/10/27- 16:48
 */

public class ShopStorePresenter extends BasePresenter<ShopStore_IView, ShopStoreModel> {
    public ShopStorePresenter(Context mContext, ShopStoreModel mModel, ShopStore_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取指定规格值或属性值的sku信息
     *
     * @param request
     */
    public void getOrderBuildData(ShopCurrentPageRequest request, final String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        }

        mView.appendNetCall(mModel.getShopStoreList(request, new IAsyncResultCallback<ShopStoreReponse>() {
            @Override
            public void onComplete(ShopStoreReponse skuInfoBean, Object userState) {
                if (null != skuInfoBean) {
                    mView.getShopStoreList(skuInfoBean, type);
                }
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                mView.stopRefresh();
                ToastUtils.toastShort(error.getMessage());
            }
        }, ""));
    }

    /**
     * 店铺取消收藏
     *
     * @param request
     */
    public void shopStoreCancle(ShopSotreCancelRequest request, final int pos) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.setShopStoreList(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.shopStoreCancelSuccess(pos);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                ToastUtils.toastShort(error.getMessage());
            }
        }, ""));
    }
}
