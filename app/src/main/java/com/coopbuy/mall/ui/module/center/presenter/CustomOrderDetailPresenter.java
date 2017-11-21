package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.CustomOrderDetailReponse;
import com.coopbuy.mall.api.reponse.CustomOrderReponse;
import com.coopbuy.mall.api.request.CustomOrderRequest;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.CustomOrderDetailModel;
import com.coopbuy.mall.ui.module.center.model.CustomOrderModel;
import com.coopbuy.mall.ui.module.center.view.CustomOrderDetail_IView;
import com.coopbuy.mall.ui.module.center.view.CustomOrder_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/17- 14:31
 */

public class CustomOrderDetailPresenter extends BasePresenter<CustomOrderDetail_IView, CustomOrderDetailModel> {


    public CustomOrderDetailPresenter(Context mContext, CustomOrderDetailModel mModel, CustomOrderDetail_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取用户订单数据
     *
     * @param request
     */
    public void getCustomOrderDetailData(OrderIdRequest request) {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getCustomOrderDetail(request, new IAsyncResultCallback<CustomOrderDetailReponse>() {
            @Override
            public void onComplete(CustomOrderDetailReponse bean, Object userState) {
                // 无数据显示
                if (bean != null) {
                    mView.getData(bean);
                    mView.stopAll();
                } else {
                    mView.showNoDataLayout();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE)
                    mView.showNetOffLayout();
                else
                    mView.showNetErrorLayout();
            }
        }, "客户订单信息"));
    }

}
