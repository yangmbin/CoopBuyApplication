package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.MyBillReponse;
import com.coopbuy.mall.api.reponse.SystemMegResponse;
import com.coopbuy.mall.api.request.CurrentPageRequest;
import com.coopbuy.mall.api.request.MegRequest;
import com.coopbuy.mall.api.request.MessageReadRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.SystemMsgModel;
import com.coopbuy.mall.ui.module.center.view.SystemMsg_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/11/1- 9:49
 */

public class SystemMsgPresenter extends BasePresenter<SystemMsg_IView, SystemMsgModel> {

    public SystemMsgPresenter(Context mContext, SystemMsgModel mModel, SystemMsg_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取系统消息数据
     *
     * @param request
     * @param type
     */
    public void getData(MegRequest request, final String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        } else {
            mView.showTransLoading();
        }

        mView.appendNetCall(mModel.getData(request, new IAsyncResultCallback<SystemMegResponse>() {
            @Override
            public void onComplete(SystemMegResponse response, Object userState) {
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

    /**
     * 阅读了一个
     *
     * @param request
     */
    public void megReadOne(MessageReadRequest request, final int postion) {
        mView.appendNetCall(mModel.sendOneRead(request, new IAsyncEmptyCallback() {
            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    error.getDetail();
                    ToastUtils.toastShort(error.getMessage());
                }
                mView.stopAll();
            }

            @Override
            public void onComplete(Object userState) {
                mView.setOneReadSuccess(postion);
            }
        }, ""));
    }

    /**
     * 全部标记已读
     *
     * @param request
     */
    public void msgReadAll(MegRequest request) {
        mView.appendNetCall(mModel.sendAllRead(request, new IAsyncEmptyCallback() {
            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    error.getDetail();
                    ToastUtils.toastShort(error.getMessage());
                }
                mView.stopAll();
            }

            @Override
            public void onComplete(Object userState) {
                mView.setAllReadSuccess();
            }
        }, ""));
    }
}
