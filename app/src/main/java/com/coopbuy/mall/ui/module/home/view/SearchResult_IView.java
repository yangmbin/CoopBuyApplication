package com.coopbuy.mall.ui.module.home.view;

import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.base.BaseView;

public interface SearchResult_IView extends BaseView {
    void setSearchResult(SearchResultResponse searchResultResponse, int loadType);
    void stopRefreshLayoutLoading();
}
