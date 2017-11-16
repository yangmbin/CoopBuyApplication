package com.coopbuy.mall.ui.module.home.presenter;


import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.api.request.SearchRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.home.model.SearchResultModel;
import com.coopbuy.mall.ui.module.home.view.SearchResult_IView;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

public class SearchResultPresenter extends BasePresenter<SearchResult_IView, SearchResultModel> {

    public static final int LOAD_TYPE_1 = 1; // 首次加载
    public static final int LOAD_TYPE_2 = 2; // 下拉刷新
    public static final int LOAD_TYPE_3 = 3; // 上拉加载
    public static final int LOAD_TYPE_4 = 4; // 切换加载

    public SearchResultPresenter(Context context, SearchResultModel model, SearchResult_IView view) {
        super(context, model, view);
    }


    /**
     * 获取搜索结果
     *
     * @param request
     * @param loadType
     */
    public void getSearchResult(SearchRequest request, final int loadType) {
        if (loadType == LOAD_TYPE_1)
            mView.showFillLoading();
        else if (loadType == LOAD_TYPE_4)
            mView.showTransLoading();
        mView.appendNetCall(mModel.getSearchResult(request, new IAsyncResultCallback<SearchResultResponse>() {
            @Override
            public void onComplete(SearchResultResponse searchResultResponse, Object userState) {
                // 无数据显示
                if (searchResultResponse.getResult().getTotalRows() == 0 && loadType != LOAD_TYPE_3) {
                    mView.showCustomLayout(R.layout.loadingbox_custom_no_search_result);
                    return;
                }
                mView.setSearchResult(searchResultResponse, loadType);
                mView.stopAll();
                mView.stopRefreshLayoutLoading();

            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopRefreshLayoutLoading();
                mView.stopAll();

                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE) {
                    mView.showNetOffLayout();
                } else {
                    mView.showNetErrorLayout();
                }
            }
        }, "获取搜索结果"));
    }
}
