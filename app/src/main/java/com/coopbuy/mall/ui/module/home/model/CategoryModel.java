package com.coopbuy.mall.ui.module.home.model;

import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

import java.util.List;


public class CategoryModel implements BaseModel {
    public IAsyncRequestState getCategoryData(IAsyncResultCallback<List<CategoryResponse>> callback, Object userState) {
        return client.getCategoryData(callback, userState);
    }
}
