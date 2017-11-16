package com.coopbuy.mall.ui.module.home.model;

import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.api.request.SearchRequest;
import com.coopbuy.mall.base.BaseModel;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;


public class SearchResultModel implements BaseModel {

    public IAsyncRequestState getSearchResult(SearchRequest request, IAsyncResultCallback<SearchResultResponse> callback, Object userState) {
        return client.getSearchResult(request, callback, userState);
    }
}
