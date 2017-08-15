package com.coopbuy.mall.ui.mainpage.model;

import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.api.login.NetClientManager;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;


public class CategoryModel implements BaseModel {

    private NetClientManager mClient = new NetClientManager();

    public void getCategory(IAsyncResultCallback<List<CategorysResponse>> callback, Object userState) {
        mClient.getCategorys(callback, null);
    }
}
