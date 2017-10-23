package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.reponse.GetBindStationReponse;
import com.coopbuy.mall.api.request.AddAddressRequest;
import com.coopbuy.mall.api.request.GetBindStationRequest;
import com.coopbuy.mall.api.request.GetChildProvincesRequest;
import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddUserAddressModel;
import com.coopbuy.mall.ui.module.center.view.AddUserAddress_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.guinong.net.NetworkException;
import com.guinong.net.callback.IAsyncEmptyCallback;
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

    public void getProvincesData(final String type) {
        // mView.showTransLoading();
        if (type.equals("again")){
            mView.showTransLoading();
        }
        mView.appendNetCall(mModel.getProvincesData(new IAsyncResultCallback<List<AreaDataResponse>>() {
            @Override
            public void onComplete(List<AreaDataResponse> addressInfoResponses, Object userState) {
                if (null != addressInfoResponses && !addressInfoResponses.isEmpty()) {
                    mView.getProviencesReponse(addressInfoResponses,type);
                    mView.stopAll();
                } else {
                    ToastUtils.toastShort("暂时没有数据");
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                  mView.stopAll();
            }
        }, "addressinfo"));
    }

    /**
     * 获取村 社区数据
     */
    public void getChildProvincesData(GetChildProvincesRequest request, final String type, final String again) {
        if (!type.equals("street"))
            mView.showTransLoading();
        mView.appendNetCall(mModel.getChildProvincesData(request, new IAsyncResultCallback<List<AddressTownResponse>>() {
            @Override
            public void onComplete(List<AddressTownResponse> addressInfoResponses, Object userState) {
                if (null != addressInfoResponses && !addressInfoResponses.isEmpty()) {
                    mView.getChileProiencesData(addressInfoResponses, type,again);
                    mView.stopAll();
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
                mView.stopAll();
            }
        }, "addressinfo"));
    }

    /**
     * 获取村 社区数据
     */
    public void getBindStationData(GetBindStationRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.getBindStationData(request, new IAsyncResultCallback<List<GetBindStationReponse>>() {
            @Override
            public void onComplete(List<GetBindStationReponse> addressInfoResponses, Object userState) {
                if (null != addressInfoResponses && !addressInfoResponses.isEmpty()) {
                    mView.getBindStationData(addressInfoResponses);
                    mView.stopAll();
                } else {
                    ToastUtils.toastShort("获取站长数据失败");
                }
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "addressinfo"));
    }

    /**
     * 添加收货地址
     *
     * @param request
     */
    public void addReciverAddress(AddAddressRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.addAddress(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.addSuccess();
                ToastUtils.toastShort("添加成功");
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "add"));
    }

    /**
     * 修改地址
     *
     * @param request
     */
    public void updateAddress(AddAddressRequest request) {
        mView.showTransLoading();
        mView.appendNetCall(mModel.updateAddress(request, new IAsyncEmptyCallback() {
            @Override
            public void onComplete(Object userState) {
                mView.addSuccess();
                ToastUtils.toastShort("修改成功");
            }

            @Override
            public void onError(NetworkException error, Object userState) {
                ToastUtils.toastShort(error.getMessage());
                mView.stopAll();
            }
        }, "add"));
    }
}
