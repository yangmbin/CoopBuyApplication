package com.coopbuy.mall.base;

import android.content.Context;

/**
 * 基类Presenter
 * @author ymb
 * Create at 2017/7/13 11:23
 */
public abstract class BasePresenter<V, M>{
    public Context mContext;
    public M mModel;
    public V mView;

    public BasePresenter(Context mContext, M mModel, V mView) {
        this.mContext = mContext;
        setVM(mView, mModel);
    }

    public void setVM(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }

    public void onDestroy() {
        mContext = null;
        mModel = null;
        mView = null;
    }
}
