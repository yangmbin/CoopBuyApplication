package com.coopbuy.mall.ui.mainpage.model;

import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.api.login.NetClientManager;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;


public class CategoryModel implements BaseModel {

    private NetClientManager mClient = new NetClientManager();

    public IAsyncRequestState getCategory(IAsyncResultCallback<List<CategoryResponse>> callback, Object userState) {
        return mClient.getCategorys(callback, null);
    }
}
