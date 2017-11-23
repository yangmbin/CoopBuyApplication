package com.coopbuy.mall.ui.mainpage.presenter;


import android.content.Context;

import com.coopbuy.mall.api.reponse.CheckUpdateResponse;
import com.coopbuy.mall.api.request.CheckUpdateRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.mainpage.model.MainModel;
import com.coopbuy.mall.ui.mainpage.view.Main_IView;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

public class MainPresenter extends BasePresenter<Main_IView, MainModel> {
    public MainPresenter(Context context, MainModel model, Main_IView view) {
        super(context, model, view);
    }

    /**
     * 检查更新
     */
    public void checkUpdate(String currentVersion) {
        CheckUpdateRequest request = new CheckUpdateRequest();
        request.setType(1); // 安卓
        request.setVersion(currentVersion);
        mView.appendNetCall(mModel.checkUpdate(request, new IAsyncResultCallback<CheckUpdateResponse>() {
            @Override
            public void onComplete(CheckUpdateResponse checkUpdateResponse, Object userState) {
                mView.setCheckUpdateData(checkUpdateResponse);
            }

            @Override
            public void onError(NetworkException error, Object userState) {

            }
        }, "检查更新"));
    }
}
