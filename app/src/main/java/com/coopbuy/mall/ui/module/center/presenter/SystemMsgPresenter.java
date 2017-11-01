package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.SystemMsgModel;
import com.coopbuy.mall.ui.module.center.view.SystemMsg_IView;

/**
 * Created by niu on 2017/11/1- 9:49
 */

public class SystemMsgPresenter extends BasePresenter<SystemMsg_IView, SystemMsgModel> {

    public SystemMsgPresenter(Context mContext, SystemMsgModel mModel, SystemMsg_IView mView) {
        super(mContext, mModel, mView);
    }
}
