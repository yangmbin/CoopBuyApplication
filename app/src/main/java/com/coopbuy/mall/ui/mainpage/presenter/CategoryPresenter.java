package com.coopbuy.mall.ui.mainpage.presenter;


import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.CategoryModel;
import com.coopbuy.mall.ui.mainpage.view.Category_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

public class CategoryPresenter extends BasePresenter<Category_IView, CategoryModel> {

    public CategoryPresenter(Context context, CategoryModel model, Category_IView view) {
        super(context, model, view);
    }

    public void getCategory() {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getCategory(new IAsyncResultCallback<List<CategorysResponse>>() {
            @Override
            public void onComplete(List<CategorysResponse> categorysResponses, Object userState) {
                mView.showCategoryData(categorysResponses);
                mView.stopAll();

                if (categorysResponses == null || categorysResponses.size() == 0)
                    mView.showNoDataLayout();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                if (error != null && error.getCode() == CodeContant.CODE_NET_UNAVAILABLE) {
                    mView.showNetOffLayout();
                    ToastUtils.toastShort(R.string.no_network);
                } else {
                    mView.showNetErrorLayout();
                    ToastUtils.toastShort(R.string.connect_server_error);
                }
            }
        }, null));
    }
}
