package com.coopbuy.mall.ui.module.center.model;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.reponse.GetBindStationReponse;
import com.coopbuy.mall.api.reponse.GetProviencesReponse;
import com.coopbuy.mall.api.request.AddAddressRequest;
import com.coopbuy.mall.api.request.GetBindStationRequest;
import com.coopbuy.mall.api.request.GetChildProvincesRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/18 0018 10:11
 * @content
 */
public class AddUserAddressModel implements BaseModel {

    public IAsyncRequestState getProvincesData(IAsyncResultCallback<List<AreaDataResponse>> callback, Object userState) {
        return client.getProvinces(callback, userState);
    }

    public IAsyncRequestState getChildProvincesData(GetChildProvincesRequest request, IAsyncResultCallback<List<AddressTownResponse>> callback, Object userState) {
        return client.getChildProvinces(request, callback, userState);
    }

    public IAsyncRequestState getBindStationData(GetBindStationRequest request, IAsyncResultCallback<List<GetBindStationReponse>> callback, Object userState) {
        return client.getStationData(request, callback, userState);
    }

    public IAsyncRequestState addAddress(AddAddressRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.addAddress(request, callback, userState);
    }
    public IAsyncRequestState updateAddress(AddAddressRequest request, IAsyncEmptyCallback callback, Object userState) {
        return client.updateAddress(request, callback, userState);
    }
}
