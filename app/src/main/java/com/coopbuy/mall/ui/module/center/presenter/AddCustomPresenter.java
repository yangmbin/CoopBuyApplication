package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.MyCustomReponse;
import com.coopbuy.mall.api.request.AddUpdateCustomRequest;
import com.coopbuy.mall.api.request.MyCustomRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddCustomModel;
import com.coopbuy.mall.ui.module.center.model.MyCustomModel;
import com.coopbuy.mall.ui.module.center.view.AddCustom_IView;
import com.coopbuy.mall.ui.module.center.view.MyCustom_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/17- 14:31
 */

public class AddCustomPresenter extends BasePresenter<AddCustom_IView, AddCustomModel> {
    public AddCustomPresenter(Context mContext, AddCustomModel mModel, AddCustom_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 添加客户
     *
     * @param request
     */
    public void addCustom(AddUpdateCustomRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.addCustom(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.addSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopRefresh();
                if (error != null) {
                    error.getDetail();
                    ToastUtils.toastShort(error.getMessage());
                }
                mView.stopAll();
            }
        }, "userinfo"));
    }

    /**
     * 更改客户信息
     *
     * @param request
     */
    public void updateCustom(AddUpdateCustomRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.updateCustom(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.updateSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopRefresh();
                if (error != null) {
                    error.getDetail();
                    ToastUtils.toastShort(error.getMessage());
                }
                mView.stopAll();
            }
        }, "userinfo"));
    }
}
