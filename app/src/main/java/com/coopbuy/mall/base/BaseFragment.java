package com.coopbuy.mall.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Fragment抽象类
 * @author ymb
 * Create at 2017/7/13 14:00
 */
public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {
    protected View rootView;
    public P mPresenter;
    public M mModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(getLayoutId(), container, false);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        initModel();
        initPresenter();
        initView();
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 获取布局文件
     */
    protected abstract int getLayoutId();

    /**
     * 初始化Model
     */
    public abstract void initModel();

    /**
     * 初始化Presenter
     */
    public abstract void initPresenter();

    /**
     * 初始化View
     */
    protected abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        if (mPresenter != null)
            mPresenter.onDestroy();
    }
}
