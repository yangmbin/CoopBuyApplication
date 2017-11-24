package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.RecommendResponse;
import com.coopbuy.mall.api.request.SetDefaultOrDeleteOrFindAddressRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddressManageModel;
import com.coopbuy.mall.ui.module.center.model.RecommendModel;
import com.coopbuy.mall.ui.module.center.view.AddressManage_IView;
import com.coopbuy.mall.ui.module.center.view.Recommend_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/17 0017 20:14
 * @content
 */
public class RecommendPresenter extends BasePresenter<Recommend_IView, RecommendModel> {

    public RecommendPresenter(Context mContext, RecommendModel mModel, Recommend_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 得到地址信息
     */
    public void getData() {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getData(new IAsyncResultCallback<List<RecommendResponse>>() {
            @Override
            public void onComplete(List<RecommendResponse> addressInfoResponses, Object userState) {
                if (null != addressInfoResponses && !addressInfoResponses.isEmpty()) {
                    mView.getRecommendData(addressInfoResponses);
                    mView.stopAll();
                } else {
                    mView.showNoDataLayout();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                mView.stopAll();
            }
        }, "addressinfo"));
    }
}
