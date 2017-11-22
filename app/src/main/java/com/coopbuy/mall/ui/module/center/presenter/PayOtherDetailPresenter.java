package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.PayOntherDetailReponse;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.PayOtherDetailModel;
import com.coopbuy.mall.ui.module.center.view.PayOtherDetail_IView;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/17- 14:31
 */

public class PayOtherDetailPresenter extends BasePresenter<PayOtherDetail_IView, PayOtherDetailModel> {


    public PayOtherDetailPresenter(Context mContext, PayOtherDetailModel mModel, PayOtherDetail_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取代付订单详情
     */
    public void getData(OrderIdRequest request) {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getPayOtherDetail(request, new IAsyncResultCallback<PayOntherDetailReponse>() {
            @Override
            public void onComplete(PayOntherDetailReponse orderDetailResponse, Object userState) {
                if (null != orderDetailResponse) {
                    mView.getData(orderDetailResponse);
                    mView.stopAll();
                } else {
                    mView.showNoDataLayout();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE) {
                    mView.showNetOffLayout();
                } else {
                    mView.showNetErrorLayout();
                }
            }
        }, "订单详情"));
    }
}
