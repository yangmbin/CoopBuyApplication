package com.coopbuy.mall.ui.module.center.presenter;

import android.content.Context;

import com.coopbuy.mall.base.BasePresenter;
import com.coopbuy.mall.ui.module.center.model.FootMarkModel;
import com.coopbuy.mall.ui.module.center.view.FootMark_IView;

/**
 * Created by niu on 2017/10/31- 9:36
 */

public class FootMarkPresenter extends BasePresenter<FootMark_IView, FootMarkModel> {
    public FootMarkPresenter(Context mContext, FootMarkModel mModel, FootMark_IView mView) {
        super(mContext, mModel, mView);
    }
}
