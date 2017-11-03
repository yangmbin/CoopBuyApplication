package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AfterSalesResponse;
import com.coopbuy.mall.api.request.PageRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AfterSalesModel;
import com.coopbuy.mall.ui.module.center.view.AfterSales_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.CodeContant;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

/**
 * @author yangmbin
 * Create at 2017/11/2 10:44
 */
public class AfterSalesPresenter extends BasePresenter<AfterSales_IView, AfterSalesModel> {

    public static final int LOAD_TYPE_1 = 1; // 普通加载
    public static final int LOAD_TYPE_2 = 2; // 下拉刷新
    public static final int LOAD_TYPE_3 = 3; // 上拉加载

    public AfterSalesPresenter(Context mContext, AfterSalesModel mModel, AfterSales_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 获取售后列表
     * @param currentPage
     */
    public void getAfterSalesList(int currentPage, final int loadType) {
        if (loadType == LOAD_TYPE_1)
            mView.showFillLoading();
        PageRequest request = new PageRequest();
        request.setCurrentPage(currentPage);
        mView.appendNetCall(mModel.getAfterSalesList(request, new IAsyncResultCallback<AfterSalesResponse>() {
            @Override
            public void onComplete(AfterSalesResponse afterSalesResponse, Object userState) {
                if (afterSalesResponse.getItems().size() == 0 && loadType == LOAD_TYPE_1) {
                    mView.showCustomLayout(R.layout.loadingbox_custom_no_order);
                    return;
                }
                mView.setAfterSalesList(afterSalesResponse);
                mView.stopAll();
                mView.stopRefreshLayoutLoading();
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error.getCode() == CodeContant.CODE_NET_UNAVAILABLE)
                    mView.showNetOffLayout();
                else
                    mView.showNetErrorLayout();
                ToastUtils.toastShort(error.getMessage());
            }
        }, "售后列表"));
    }
}
