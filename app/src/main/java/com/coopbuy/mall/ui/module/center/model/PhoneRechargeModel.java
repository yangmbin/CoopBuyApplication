package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.CheckPhoneReponse;
import com.coopbuy.mall.api.reponse.PhoneRechargeListReponse;
import com.coopbuy.mall.api.request.CheckPhoneRequest;
import com.coopbuy.mall.api.request.SuggestRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * Created by niu on 2017/10/31- 17:12
 */

public class PhoneRechargeModel implements BaseModel {

    public IAsyncRequestState getMobileCardList(IAsyncResultCallback<List<PhoneRechargeListReponse>> callback, Object userState) {
        return client.getMobileCardList(callback, userState);
    }

    public IAsyncRequestState checkPhone(CheckPhoneRequest request, IAsyncResultCallback<CheckPhoneReponse> callback, Object userState) {
        return client.checkPhone(request, callback, userState);
    }
}
