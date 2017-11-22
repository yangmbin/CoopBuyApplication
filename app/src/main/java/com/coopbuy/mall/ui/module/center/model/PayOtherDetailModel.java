package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.PayOntherDetailReponse;
import com.coopbuy.mall.api.request.OrderIdRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public class PayOtherDetailModel implements BaseModel {
    public IAsyncRequestState getPayOtherDetail(OrderIdRequest request, IAsyncResultCallback<PayOntherDetailReponse>  callback, Object userState) {
        return client.getPayOtherDetail(request, callback, userState);
    }
}
