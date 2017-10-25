package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.api.request.UploadImageRequest;
import com.coopbuy.mall.base.BaseModel;
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
}
