package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.LogisticsModel;
import com.coopbuy.mall.ui.module.center.model.SystemMsgModel;
import com.coopbuy.mall.ui.module.center.view.Logistics_IView;
import com.coopbuy.mall.ui.module.center.view.SystemMsg_IView;

/**
 * Created by niu on 2017/11/1- 9:49
 */

public class LogisticsPresenter extends BasePresenter<Logistics_IView, LogisticsModel> {


    public LogisticsPresenter(Context mContext, LogisticsModel mModel, Logistics_IView mView) {
        super(mContext, mModel, mView);
    }
}
