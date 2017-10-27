package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ExpressInfoResponse;
import com.coopbuy.mall.api.reponse.LoginResponse;
import com.coopbuy.mall.api.request.ImageCodeRequest;
import com.coopbuy.mall.api.request.LoginRequest;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.ExpressInfoModel;
import com.coopbuy.mall.ui.module.center.model.LoginModel;
import com.coopbuy.mall.ui.module.center.view.ExpressInfo_IView;
import com.coopbuy.mall.ui.module.center.view.Login_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * @author yangmbin
 *         Create at 2017/10/27 16:53
 */
public class ExpressInfoPresenter extends BasePresenter<ExpressInfo_IView, ExpressInfoModel> {

    public ExpressInfoPresenter(Context mContext, ExpressInfoModel mModel, ExpressInfo_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取物流信息
     *
     * @param orderId
     */
    public void getExpressInfo(String orderId) {
        mView.showFillLoading();
        OrderIdRequest request = new OrderIdRequest();
        request.setOrderId(orderId);
        mView.appendNetCall(mModel.getExpressInfo(request, new IAsyncResultCallback<ExpressInfoResponse>() {
            @Override
            public void onComplete(ExpressInfoResponse expressInfoResponse, Object userState) {
                // 无数据显示
                if (expressInfoResponse.getNodes() == null || expressInfoResponse.getNodes().size() == 0) {
                    mView.showCustomLayout(R.layout.loadingbox_custom_no_order);
                }
                else {
                    mView.setExpressInfo(expressInfoResponse);
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
        }, "获取物流信息"));
    }
}
