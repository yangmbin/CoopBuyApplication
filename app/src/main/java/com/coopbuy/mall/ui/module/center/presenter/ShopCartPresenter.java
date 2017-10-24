package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.RegisterResponse;
import com.coopbuy.mall.api.reponse.ShopCartReponse;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.ShopCartModel;
import com.coopbuy.mall.ui.module.center.view.ShopCart_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/10/24.
 */

public class ShopCartPresenter extends BasePresenter<ShopCart_IView, ShopCartModel> {
    public ShopCartPresenter(Context mContext, ShopCartModel mModel, ShopCart_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获得购物车数据
     *
     * @param type
     */
    public void getShopCartDatga(String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        } else {
            mView.showTransLoading();
        }

        mView.appendNetCall(mModel.getShopCartData(new IAsyncResultCallback<ShopCartReponse>() {
            @Override
            public void onComplete(ShopCartReponse smsCodeReponse, Object userState) {
                if (!smsCodeReponse.getShops().isEmpty()) {
                    mView.getShopCartData(smsCodeReponse);
                    mView.stopAll();
                } else {
                    mView.showNoDataLayout();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "shopcartdata"));
    }
}
