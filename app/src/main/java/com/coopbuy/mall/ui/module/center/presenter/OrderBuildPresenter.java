package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;
import com.coopbuy.mall.api.reponse.OrderBuildResponse;
import com.coopbuy.mall.api.request.OrderBuildRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.OrderBuildModel;
import com.coopbuy.mall.ui.module.center.view.OrderBuild_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * Created by niu on 2017/10/26- 14:01
 */

public class OrderBuildPresenter extends BasePresenter<OrderBuild_IView, OrderBuildModel> {
    public OrderBuildPresenter(Context mContext, OrderBuildModel mModel, OrderBuild_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取指定规格值或属性值的sku信息
     *
     * @param request
     */
    public void getOrderBuildData(OrderBuildRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.getOrderBuildData(request, new IAsyncResultCallback<OrderBuildResponse>() {
            @Override
            public void onComplete(OrderBuildResponse skuInfoBean, Object userState) {
                if (null != skuInfoBean) {
                    mView.getOrderBuildData(skuInfoBean);
                }
                mView.stopAll();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
                mView.fail();
                ToastUtils.toastShort(error.getMessage());
            }
        }, ""));
    }
}
