package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.AfterSalesDetailResponse;
import com.coopbuy.mall.api.request.AfterSalesDetailRequest;
import com.coopbuy.mall.api.request.CancelApplyRefundRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AfterSalesDetailModel;
import com.coopbuy.mall.ui.module.center.view.AfterSalesDetail_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * @author yangmbin
 * Create at 2017/11/2 10:44
 */
public class AfterSalesDetailPresenter extends BasePresenter<AfterSalesDetail_IView, AfterSalesDetailModel> {

    public AfterSalesDetailPresenter(Context mContext, AfterSalesDetailModel mModel, AfterSalesDetail_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取售后详情
     * @param applyNo
     */
    public void getAfterSalesDetail(String applyNo) {
        mView.showFillLoading();
        AfterSalesDetailRequest request = new AfterSalesDetailRequest();
        request.setApplyNo(applyNo);
        mView.appendNetCall(mModel.getAfterSalesDetail(request, new IAsyncResultCallback<AfterSalesDetailResponse>() {
            @Override
            public void onComplete(AfterSalesDetailResponse afterSalesDetailResponse, Object userState) {
                mView.setAfterSalesDetail(afterSalesDetailResponse);
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
        }, "售后详情"));
    }


    /**
     * 取消申请退款
     * @param applyNo
     */
    public void cancelApplyRefund(String applyNo) {
        mView.showTransLoading();
        CancelApplyRefundRequest request = new CancelApplyRefundRequest();
        request.setApplyNo(applyNo);
        mView.appendNetCall(mModel.cancelApplyRefund(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.cancelApplySuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "取消申请退款"));
    }
}
