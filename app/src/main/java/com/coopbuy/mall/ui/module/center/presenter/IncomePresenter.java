package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.InComeReponse;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.IncomeModel;
import com.coopbuy.mall.ui.module.center.view.Income_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/17- 14:31
 */

public class IncomePresenter extends BasePresenter<Income_IView, IncomeModel> {
    public IncomePresenter(Context mContext, IncomeModel mModel, Income_IView mView) {
        super(mContext, mModel, mView);
    }

    public void getIncome(CurrentPageRequest request, final String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        } else {
            mView.showTransLoading();
        }

        mView.appendNetCall(mModel.getInComeData(request, new IAsyncResultCallback<InComeReponse>() {
            @Override
            public void onComplete(InComeReponse response, Object userState) {
                mView.stopRefresh();
                if (response.getItems().isEmpty()) {
                    mView.showNoDataLayout();
                } else {
                    if (type.equals("more")) {
                        ToastUtils.toastShort("没有数据了");
                        mView.stopAll();
                    } else {
                        mView.getData(response, type);
                    }
                    mView.stopAll();
                }
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
