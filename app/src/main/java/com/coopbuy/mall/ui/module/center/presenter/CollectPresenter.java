package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.api.reponse.UserCenterInfoResponse;
import com.coopbuy.mall.api.request.CollectRequest;
import com.coopbuy.mall.api.request.PublishProductRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.CollectModel;
import com.coopbuy.mall.ui.module.center.view.Collect_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

/**
 * Created by niu on 2017/11/8- 10:33
 */

public class CollectPresenter extends BasePresenter<Collect_IView, CollectModel> {
    public CollectPresenter(Context mContext, CollectModel mModel, Collect_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取站长推荐列表
     *
     * @param request
     * @param type
     */
    public void getUserInfoData(CollectRequest request, final String type) {
        if (type.equals("init")) {
            mView.showFillLoading();
        }
        mView.appendNetCall(mModel.getCollectData(request, new IAsyncResultCallback<CollectResponse>() {
            @Override
            public void onComplete(CollectResponse response, Object userState) {
                mView.stopAll();
                if (!response.getItems().isEmpty()) {
                    mView.getCollectData(response, type);
                } else {
                    if (type.equals("load")) {
                        ToastUtils.toastShort("没有更多数据了");
                    } else {
                        mView.showNoDataLayout();
                    }
                }
                mView.stopRefresh();
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
     * 更新站长推荐商品是否选中的状态
     *
     * @param request
     * @param type
     */
    public void updateStatus(SkuDetailRequest request, final int type) {

        mView.appendNetCall(mModel.getCollectData(request, new IAsyncEmptyCallback() {
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
                mView.updateSuccess(type);
                mView.stopAll();
            }
        }, "userinfo"));
    }

    /**
     * 站长 发布商品
     *
     * @param request
     */
    public void publishProduct(PublishProductRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.publishProduct(request, new IAsyncEmptyCallback() {
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
                mView.publishSuccess();
                mView.stopAll();
            }
        }, "userinfo"));
    }

    public void removeFovorite(SkuDetailRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.removeFovorite(request, new IAsyncEmptyCallback() {
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
                mView.removeSuccess();
                mView.stopAll();
            }
        }, "userinfo"));
    }
}
