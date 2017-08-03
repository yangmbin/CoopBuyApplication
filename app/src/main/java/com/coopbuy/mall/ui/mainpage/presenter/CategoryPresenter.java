package com.coopbuy.mall.ui.mainpage.presenter;


import android.content.Context;

import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.CategoryModel;
import com.coopbuy.mall.ui.mainpage.view.Category_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

public class CategoryPresenter extends BasePresenter<Category_IView, CategoryModel> {

    public CategoryPresenter(Context context, CategoryModel model, Category_IView view) {
        super(context, model, view);
    }

    public void getCategory() {
        mView.showFillLoading();
        mModel.getCategory(new IAsyncResultCallback<List<CategorysResponse>>() {
            @Override
            public void onComplete(List<CategorysResponse> categorysResponses, Object userState) {
                ToastUtils.toastShort("success");
                mView.showCategoryData(categorysResponses);
                mView.stopLoading();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort("fail");
                mView.stopLoading();
            }
        }, null);
    }
}
