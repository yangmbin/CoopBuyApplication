package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.request.GetChildProvincesRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddUserAddressModel;
import com.coopbuy.mall.ui.module.center.view.AddUserAddress_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncResultCallback;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/18 0018 10:11
 * @content
 */
public class AddUserAddressPresenter extends BasePresenter<AddUserAddress_IView, AddUserAddressModel> {
    public AddUserAddressPresenter(Context mContext, AddUserAddressModel mModel, AddUserAddress_IView mView) {
        super(mContext, mModel, mView);
    }

    public void getProvincesData() {
        // mView.showTransLoading();
        mView.appendNetCall(mModel.getProvincesData(new IAsyncResultCallback<List<AreaDataResponse>>() {
            @Override
            public void onComplete(List<AreaDataResponse> addressInfoResponses, Object userState) {
                if (null != addressInfoResponses && !addressInfoResponses.isEmpty()) {
                    mView.getProviencesReponse(addressInfoResponses);
                    //mView.stopAll();
                } else {
                    ToastUtils.toastShort("暂时没有数据");
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                //  mView.stopAll();
            }
        }, "addressinfo"));
    }

    /**
     * 获取村 社区数据
     */
    public void getChildProvincesData(GetChildProvincesRequest request, final String type) {
        // mView.showTransLoading();
        mView.appendNetCall(mModel.getChildProvincesData(request, new IAsyncResultCallback<List<AddressTownResponse>>() {
            @Override
            public void onComplete(List<AddressTownResponse> addressInfoResponses, Object userState) {
                if (null != addressInfoResponses && !addressInfoResponses.isEmpty()) {
                    mView.getChileProiencesData(addressInfoResponses);
                    //mView.stopAll();
                } else {
                    if (type.equals("street")) {
                        mView.getStreetFail();
                    } else {
                        mView.getConmmunityFail();
                    }
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                //  mView.stopAll();
            }
        }, "addressinfo"));
    }
}
