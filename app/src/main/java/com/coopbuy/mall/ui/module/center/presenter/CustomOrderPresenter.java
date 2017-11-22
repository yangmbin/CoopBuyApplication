package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CustomOrderReponse;
import com.coopbuy.mall.api.reponse.ExpressInfoResponse;
import com.coopbuy.mall.api.request.AddUpdateCustomRequest;
import com.coopbuy.mall.api.request.CustomOrderRequest;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddCustomModel;
import com.coopbuy.mall.ui.module.center.model.CustomOrderModel;
import com.coopbuy.mall.ui.module.center.view.AddCustom_IView;
import com.coopbuy.mall.ui.module.center.view.CustomOrder_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/17- 14:31
 */

public class CustomOrderPresenter extends BasePresenter<CustomOrder_IView, CustomOrderModel> {

    public CustomOrderPresenter(Context mContext, CustomOrderModel mModel, CustomOrder_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取用户订单数据
     *
     * @param request
     * @param type
     */
    public void getCustomOrderData(CustomOrderRequest request, final String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        }
        mView.appendNetCall(mModel.getCustomOrder(request, new IAsyncResultCallback<CustomOrderReponse>() {
            @Override
            public void onComplete(CustomOrderReponse bean, Object userState) {
                // 无数据显示
                mView.stopRefresh();
                if (bean.getItems().isEmpty()) {
                    if (type.equals("more")) {
                        ToastUtils.toastShort("没有数据了");
                        mView.stopAll();
                    } else {
                        mView.showNoDataLayout();
                    }
                } else {
                    mView.getData(bean, type);
                    mView.stopAll();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopRefresh();
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE)
                    mView.showNetOffLayout();
                else
                    mView.showNetErrorLayout();
            }
        }, "客户订单信息"));
    }

}
