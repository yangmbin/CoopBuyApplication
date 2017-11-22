package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.MesCenterResponse;
import com.coopbuy.mall.api.request.SetDefaultOrDeleteOrFindAddressRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddressManageModel;
import com.coopbuy.mall.ui.module.center.model.MesgCenterModel;
import com.coopbuy.mall.ui.module.center.view.AddressManage_IView;
import com.coopbuy.mall.ui.module.center.view.MsgCenter_IView;
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
public class MesgCenterPresenter extends BasePresenter<MsgCenter_IView, MesgCenterModel> {


    public MesgCenterPresenter(Context mContext, MesgCenterModel mModel, MsgCenter_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 得到地址信息
     */
    public void getData() {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getData(new IAsyncResultCallback<List<MesCenterResponse>>() {
            @Override
            public void onComplete(List<MesCenterResponse> addressInfoResponses, Object userState) {
                if (null != addressInfoResponses && !addressInfoResponses.isEmpty()) {
                    mView.getData(addressInfoResponses);
                    mView.stopAll();
                } else {
                    mView.showNoDataLayout();
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                if (error != null) {
                    error.getDetail();
                    ToastUtils.toastShort(error.getMessage());
                }
                mView.stopAll();
            }
        }, "addressinfo"));
    }
}
