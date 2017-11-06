package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.BeforeApplyRefundResponse;
import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.api.request.ApplyRefundRequest;
import com.coopbuy.mall.api.request.BeforeApplyRefundRequest;
import com.coopbuy.mall.api.request.UploadImageRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author ymb
 * Create at 2017/10/24 20:29
 */
public class ApplyRefundModel implements BaseModel {

    public IAsyncRequestState uploadImage(UploadImageRequest request, IAsyncResultCallback<UploadImageResponse> callback, Object userState) {
        return client.uploadImage(request, callback, userState);
    }

    public IAsyncRequestState beforeApplyRefund(BeforeApplyRefundRequest request, IAsyncResultCallback<BeforeApplyRefundResponse> callback, Object userState) {
        return client.beforeApplyRefund(request, callback, userState);
    }

    public IAsyncRequestState submitApplyRefund(ApplyRefundRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.submitApplyRefund(request, callback, userState);
    }
}
