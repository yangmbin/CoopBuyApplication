package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.BeforeApplyRefundResponse;
import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.api.request.ApplyRefundRequest;
import com.coopbuy.mall.api.request.BeforeApplyRefundRequest;
import com.coopbuy.mall.api.request.UploadImageRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.ApplyRefundModel;
import com.coopbuy.mall.ui.module.center.view.ApplyRefund_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;


/**
 * @author ymb
 * Create at 2017/10/24 20:29
 */
public class ApplyRefundPresenter extends BasePresenter<ApplyRefund_IView, ApplyRefundModel> {
    public ApplyRefundPresenter(Context mContext, ApplyRefundModel mModel, ApplyRefund_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 上传图片
     * @param request
     */
    public void uploadImage(UploadImageRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.uploadImage(request, new IAsyncResultCallback<UploadImageResponse>() {
            @Override
            public void onComplete(UploadImageResponse uploadImageResponse, Object userState) {
                ToastUtils.toastShort("上传成功");
                mView.uploadImageSuccess(uploadImageResponse);
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort("上传失败");
                mView.stopAll();
            }
        }, "上传图片"));
    }

    /**
     * 进入退款页面获取数据
     * @param request
     */
    public void beforeApplyRefund(BeforeApplyRefundRequest request) {
        mView.showFillLoading();
        mView.appendNetCall(mModel.beforeApplyRefund(request, new IAsyncResultCallback<BeforeApplyRefundResponse>() {
            @Override
            public void onComplete(BeforeApplyRefundResponse beforeApplyRefundResponse, Object userState) {
                mView.setBeforeApplyRefundData(beforeApplyRefundResponse);
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
        }, "进入退款页面获取数据"));
    }

    /**
     * 首次提交退款申请
     * @param request
     */
    public void submitApplyRefund(ApplyRefundRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.submitApplyRefund(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.submitApplyRefundSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "首次提交退款申请"));
    }

    /**
     * 重新提交退款申请
     * @param request
     */
    public void submitReApplyRefund(ApplyRefundRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.submitReApplyRefund(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.submitApplyRefundSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "重新提交退款申请"));
    }
}
