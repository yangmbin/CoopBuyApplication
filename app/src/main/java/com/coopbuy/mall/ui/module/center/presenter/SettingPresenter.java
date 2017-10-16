package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.SettingModel;
import com.coopbuy.mall.ui.module.center.view.Setting_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;


/**
 * @author csn
 * @date 2017/10/16 0016 14:04
 * @content
 */
public class SettingPresenter extends BasePresenter<Setting_IView, SettingModel> {
    public SettingPresenter(Context mContext, SettingModel mModel, Setting_IView mView) {
        super(mContext, mModel, mView);
    }

    public void quit() {
        mView.showTransLoading();
        mView.appendNetCall(mModel.quit(new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.quitSucces();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    ToastUtils.toastShort(error.getDetail());
                    mView.quitFail(error.getDetail());
                    mView.stopAll();
                }
            }
        }, "quit"));
    }
}
