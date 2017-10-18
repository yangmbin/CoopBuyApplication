package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddressManageModel;
import com.coopbuy.mall.ui.module.center.view.AddressManage_IView;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/17 0017 20:14
 * @content
 */
public class AddressManagePresenter extends BasePresenter<AddressManage_IView, AddressManageModel> {
    public AddressManagePresenter(Context mContext, AddressManageModel mModel, AddressManage_IView mView) {
        super(mContext, mModel, mView);
    }

    /**
     * 得到地址信息
     */
    public void getAddressData() {
        mView.showFillLoading();
        mView.appendNetCall(mModel.getAddressData(new IAsyncResultCallback<List<AddressInfoResponse>>() {
            @Override
            public void onComplete(List<AddressInfoResponse> addressInfoResponses, Object userState) {
                if (null != addressInfoResponses && !addressInfoResponses.isEmpty()) {
                    mView.getAddressMangeData(addressInfoResponses);
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
