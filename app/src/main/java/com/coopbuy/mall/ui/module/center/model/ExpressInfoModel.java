package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.ExpressInfoResponse;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.api.request.RefundExpressInfoRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * @author yangmbin
 * Create at 2017/10/27 16:51
 */
public class ExpressInfoModel implements BaseModel {
    public IAsyncRequestState getExpressInfo(OrderIdRequest request, IAsyncResultCallback<ExpressInfoResponse> callback, Object userState) {
        return client.getExpressInfo(request, callback, userState);
    }

    public IAsyncRequestState getRefundExpressInfo(RefundExpressInfoRequest request, IAsyncResultCallback<ExpressInfoResponse> callback, Object userState) {
        return client.getRefundExpressInfo(request, callback, userState);
    }
}
