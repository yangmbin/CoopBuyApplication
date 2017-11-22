package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.MesCenterResponse;
import com.coopbuy.mall.api.reponse.OrderSubmitResponse;
import com.coopbuy.mall.api.request.AddUpdateCustomRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public class MesgCenterModel implements BaseModel {
    public IAsyncRequestState getData(IAsyncResultCallback<List<MesCenterResponse>> callback, Object userState) {
        return client.getMesgCenterData( callback, userState);
    }
}
