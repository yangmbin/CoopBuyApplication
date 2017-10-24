package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.api.request.UploadImageRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.ApplyRefundModel;
import com.coopbuy.mall.ui.module.center.view.ApplyRefund_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
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
}
