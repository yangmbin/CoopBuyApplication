package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.AddressManageModel;
import com.coopbuy.mall.ui.module.center.view.AddressManage_IView;

/**
 * @author csn
 * @date 2017/10/17 0017 20:14
 * @content
 */
public class AddressManagePresenter extends BasePresenter<AddressManage_IView, AddressManageModel> {
    public AddressManagePresenter(Context mContext, AddressManageModel mModel, AddressManage_IView mView) {
        super(mContext, mModel, mView);
    }
}
