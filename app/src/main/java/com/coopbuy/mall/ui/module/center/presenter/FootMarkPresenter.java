package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.FootMarkResponse;
import com.coopbuy.mall.api.request.DeleteFootRequest;
import com.coopbuy.mall.api.request.ShopCurrentPageRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.FootMarkModel;
import com.coopbuy.mall.ui.module.center.view.FootMark_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/10/31- 9:36
 */

public class FootMarkPresenter extends BasePresenter<FootMark_IView, FootMarkModel> {
    public FootMarkPresenter(Context mContext, FootMarkModel mModel, FootMark_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 足迹
     *
     * @param request
     * @param type
     */
    public void getOrderBuildData(ShopCurrentPageRequest request, final String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        }
        mView.appendNetCall(mModel.footMarkData(request, new IAsyncResultCallback<FootMarkResponse>() {
            @Override
            public void onComplete(FootMarkResponse skuInfoBean, Object userState) {
                mView.stopRefresh();
                if (null != skuInfoBean && !skuInfoBean.getItems().isEmpty()) {
                    mView.getFootMarkData(skuInfoBean, type);
                    mView.stopAll();
                } else {
                    if (type.equals("add")) {
                        ToastUtils.toastShort("没有更多数据了");
                    } else {
                        mView.showNoDataLayout();
                    }
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                mView.stopRefresh();
                ToastUtils.toastShort(error.getMessage());
            }
        }, ""));
    }

    /**
     * 足迹
     *
     * @param request
     */
    public void deleteOne(DeleteFootRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.footMarkData(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.deleteOneSuccess();
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                mView.stopRefresh();
                ToastUtils.toastShort(error.getMessage());
            }
        }, ""));
    }
}
