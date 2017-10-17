package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.CenterModel;
import com.coopbuy.mall.ui.module.center.view.Center_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * @author csn
 * @date 2017/10/17 0017 14:28
 * @content
 */
public class CenterPresenter extends BasePresenter<Center_IView, CenterModel> {
    public CenterPresenter(Context mContext, CenterModel mModel, Center_IView mView) {
        super(mContext, mModel, mView);
    }

    public void getUserInfoData() {
        mView.appendNetCall(mModel.getUserInfo(new IAsyncResultCallback<UserCenterInfoResponse>() {
            @Override
            public void onComplete(UserCenterInfoResponse response, Object userState) {
                mView.getUserData(response);
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    error.getDetail();
                    ToastUtils.toastShort(error.getMessage());
                }
            }
        }, "userinfo"));
    }
}
