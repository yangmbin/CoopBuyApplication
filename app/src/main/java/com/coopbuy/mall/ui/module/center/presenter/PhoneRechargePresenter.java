package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.CheckPhoneReponse;
import com.coopbuy.mall.api.reponse.PhoneRechargeListReponse;
import com.coopbuy.mall.api.request.MobilePayRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.PhoneRechargeModel;
import com.coopbuy.mall.ui.module.center.view.PhoneRecharge_IView;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

/**
 * Created by niu on 2017/11/3- 14:50
 */

public class PhoneRechargePresenter extends BasePresenter<PhoneRecharge_IView, PhoneRechargeModel> {
    public PhoneRechargePresenter(Context mContext, PhoneRechargeModel mModel, PhoneRecharge_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取电话充值列表
     */
    public void getMobilList() {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getMobileCardList(new IAsyncResultCallback<List<PhoneRechargeListReponse>>() {
            @Override
            public void onComplete(List<PhoneRechargeListReponse> orderDetailResponse, Object userState) {
                if (!orderDetailResponse.isEmpty()) {
                    mView.getMobilData(orderDetailResponse);
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

    /**
     * 电话归属地查询
     *
     * @param request
     */
    public void getCheckPhoneData(MobilePayRequest request) {
        mView.appendNetCall(mModel.checkPhone(request, new IAsyncResultCallback<CheckPhoneReponse>() {
            @Override
            public void onComplete(CheckPhoneReponse orderDetailResponse, Object userState) {
                if (orderDetailResponse != null) {
                    mView.getCheckPhoneData(orderDetailResponse);
                    mView.stopAll();
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
