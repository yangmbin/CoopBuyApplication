package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.FootMarkResponse;
import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.api.request.DeleteFootRequest;
import com.coopbuy.mall.api.request.ShopCurrentPageRequest;
import com.coopbuy.mall.api.request.UploadImageRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/10/31- 9:36
 */

public class FootMarkModel implements BaseModel {
    public IAsyncRequestState footMarkData(ShopCurrentPageRequest request, IAsyncResultCallback<FootMarkResponse> callback, Object userState) {
        return client.footMarkData(request, callback, userState);
    }  public IAsyncRequestState footMarkData(DeleteFootRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.deletefootMarkone(request, callback, userState);
    }
}
