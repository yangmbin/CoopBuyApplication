package com.coopbuy.mall.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coopbuy.mall.R;
import com.coopbuy.mall.widget.LoadingBox;

import butterknife.ButterKnife;

/**
 * Fragment抽象类
 *
 * @author ymb
 *         Create at 2017/7/13 14:00
 */
public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment implements View.OnClickListener {
    public P mPresenter;
    public M mModel;
    public Context mContext;
    private View rootView;
    private LoadingBox box;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        mContext = this.getActivity();
        if (rootView.findViewById(R.id.box) != null) {
            box = new LoadingBox(mContext, rootView.findViewById(R.id.box));
            box.setClickListener(this);
        }
        ButterKnife.bind(this, rootView);
        initModel();
        initView();
        initPresenter();

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

    /**
     * 全覆盖加载框
     */
    public void showFillLoading() {
        box.showLoadingLayout();
    }

    /**
     * 显示透明加载框
     */
    public void showTransLoading() {
        box.showTransLoadingLayout();
    }

    /**
     * 显示无数据页面
     */
    public void showNoDataLayout() {
        box.showNoDataLayout();
    }

    /**
     * 显示无网络页面
     */
    public void showNetOffLayout() {
        box.showInternetOffLayout();
    }

    /**
     * 显示网络错误页面
     */
    public void showNetErrorLayout() {
        box.showExceptionLayout();
    }

    /**
     * 停止加载框
     */
    public void stopLoading() {
        box.hideAll();
    }

    /**
     * 网络重载按钮监听
     * @param view
     */
    @Override
    public void onClick(View view) {
        networkRetry();
    }

    /**
     * 网络重载按钮
     */
    protected void networkRetry() {}


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        if (mPresenter != null)
            mPresenter.onDestroy();
    }
}
