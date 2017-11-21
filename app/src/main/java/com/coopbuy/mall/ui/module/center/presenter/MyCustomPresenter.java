package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.MyBillReponse;
import com.coopbuy.mall.api.reponse.MyCustomReponse;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.api.request.MyCustomRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.MyBillModel;
import com.coopbuy.mall.ui.module.center.model.MyCustomModel;
import com.coopbuy.mall.ui.module.center.view.MyBill_IView;
import com.coopbuy.mall.ui.module.center.view.MyCustom_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/17- 14:31
 */

public class MyCustomPresenter extends BasePresenter<MyCustom_IView, MyCustomModel> {


    public MyCustomPresenter(Context mContext, MyCustomModel mModel, MyCustom_IView mView) {
        super(mContext, mModel, mView);
    }

    public void getData(MyCustomRequest request, final String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        } else if (type.equals("search")) {
            mView.showTransLoading();
        }
        mView.appendNetCall(mModel.getData(request, new IAsyncResultCallback<MyCustomReponse>() {
            @Override
            public void onComplete(MyCustomReponse response, Object userState) {
                mView.stopRefresh();
                if (response.getItems().isEmpty()) {
                    if (type.equals("more")) {
                        ToastUtils.toastShort("没有数据了");
                        mView.stopAll();
                    } else {
                        mView.showNoDataLayout();
                    }
                } else {
                    mView.getData(response, type);
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
