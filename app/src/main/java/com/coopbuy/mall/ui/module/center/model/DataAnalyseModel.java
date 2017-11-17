package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.DataAnalyseResponse;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public class DataAnalyseModel implements BaseModel {
    public IAsyncRequestState getDataAnalyse(IAsyncResultCallback<DataAnalyseResponse> callback, Object userState) {
        return client.getDataAnalyse (callback, userState);
    }
}
