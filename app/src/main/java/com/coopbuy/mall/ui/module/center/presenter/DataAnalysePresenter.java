package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.api.reponse.DataAnalyseResponse;
import com.coopbuy.mall.api.request.CollectRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.DataAnalyseModel;
import com.coopbuy.mall.ui.module.center.view.DataAnalyse_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/17- 13:51
 */

public class DataAnalysePresenter extends BasePresenter<DataAnalyse_IView, DataAnalyseModel> {
    public DataAnalysePresenter(Context mContext, DataAnalyseModel mModel, DataAnalyse_IView mView) {
        super(mContext, mModel, mView);
    }

    public void getDataAnalyse() {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getDataAnalyse( new IAsyncResultCallback<DataAnalyseResponse>() {
            @Override
            public void onComplete(DataAnalyseResponse response, Object userState) {
                if (null!=response){
                    mView.stopAll();
                    mView.getData(response);
                }else {
                    mView.showNoDataLayout();
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
