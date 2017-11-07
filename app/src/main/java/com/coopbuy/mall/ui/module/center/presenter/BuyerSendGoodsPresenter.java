package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.ShippingCompanyResponse;
import com.coopbuy.mall.api.request.BuyerSendGoodsRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.BuyerSendGoodsModel;
import com.coopbuy.mall.ui.module.center.view.BuyerSendGoods_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;


/**
 * @author ymb
 * Create at 2017/10/24 20:29
 */
public class BuyerSendGoodsPresenter extends BasePresenter<BuyerSendGoods_IView, BuyerSendGoodsModel> {
    public BuyerSendGoodsPresenter(Context mContext, BuyerSendGoodsModel mModel, BuyerSendGoods_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取物流公司列表
     */
    public void getShippingCampanyList() {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getShippingCompanyList(new IAsyncResultCallback<List<ShippingCompanyResponse>>() {
            @Override
            public void onComplete(List<ShippingCompanyResponse> shippingCompanyResponseList, Object userState) {
                mView.setShippingCompanyList(shippingCompanyResponseList);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE)
                    mView.showNetOffLayout();
                else
                    mView.showNetErrorLayout();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "获取物流公司列表"));
    }


    /**
     * 买家寄货
     */
    public void sendGoods(BuyerSendGoodsRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.sendGoods(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.sendGoodsSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "买家寄货"));
    }
}
