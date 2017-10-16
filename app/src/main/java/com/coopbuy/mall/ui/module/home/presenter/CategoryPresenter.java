package com.coopbuy.mall.ui.module.home.presenter;


import android.content.Context;

import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.home.model.CategoryModel;
import com.coopbuy.mall.ui.module.home.view.Category_IView;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

public class CategoryPresenter extends BasePresenter<Category_IView, CategoryModel> {

    public CategoryPresenter(Context context, CategoryModel model, Category_IView view) {
        super(context, model, view);
    }

    /**
     * 获取分类数据
     */
    public void getCategoryData() {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getCategoryData(new IAsyncResultCallback<List<CategoryResponse>>() {
            @Override
            public void onComplete(List<CategoryResponse> categoryResponses, Object userState) {
                if (categoryResponses == null || categoryResponses.size() == 0)
                    mView.showNoDataLayout();
                else {
                    mView.setCategoryData(categoryResponses);
                    mView.stopAll();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE)
                    mView.showNetOffLayout();
                else
                    mView.showNetErrorLayout();
            }
        }, "分类"));

    }
}
