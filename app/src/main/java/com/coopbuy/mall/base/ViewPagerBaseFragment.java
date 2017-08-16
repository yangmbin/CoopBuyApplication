package com.coopbuy.mall.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coopbuy.mall.R;
import com.coopbuy.mall.widget.LoadingBox;
import com.guinong.net.request.IAsyncRequestState;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Fragment抽象类，配合ViewPager使用，实现懒加载
 *
 * @author ymb
 *         Create at 2017/7/13 14:00
 */
public abstract class ViewPagerBaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {
    public P mPresenter;
    public M mModel;
    public Context mContext;
    private View rootView;
    private LoadingBox box;
    public List<IAsyncRequestState> mNetCalls = new ArrayList<>();

    // 是否创建了视图
    private boolean hasCreateView;
    // Fragment是否可见
    private boolean isFragmentVisible;
    // Fragment第一次可见
    private boolean isFragmentFirstVisible = true;

    private View.OnClickListener mReloadListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            networkRetry();
        }
    };

    private View.OnClickListener mCustomListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            customClick();
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hasCreateView = false;
        isFragmentVisible = false;
    }

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
            box.setClickListener(mReloadListener);
            box.setCustomClickListener(mCustomListener);
        }
        ButterKnife.bind(this, rootView);
        initModel();
        initView();
        initPresenter();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!hasCreateView && getUserVisibleHint()) {
            judgeIsFirst();
            onFragmentVisible(true);
            isFragmentVisible = true;
        }
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
     * 显示自定义页面
     */
    public void showCustomLayout(int layoutId) {
        View customView = getActivity().getLayoutInflater().inflate(layoutId, null, false);
        box.addCustomView(customView, layoutId + "");
        box.showCustomView(layoutId + "");
    }

    /**
     * 隐藏所有覆盖层,显示正常页面
     */
    public void stopAll() {
        box.hideAll();
    }

    /**
     * 网络重载按钮
     */
    protected void networkRetry() {
    }

    /**
     * 自定义页面按钮
     */
    protected void customClick() {
    }

    /**
     * 判断Fragment是否可见，先于onCreateView执行
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (rootView == null)
            return;
        hasCreateView = true;
        if (isVisibleToUser) {
            judgeIsFirst();
            onFragmentVisible(true);
            isFragmentVisible = true;
            return;
        }
        if (isFragmentVisible) {
            onFragmentVisible(false);
            isFragmentVisible = false;
        }
    }

    /**
     * 子类重写，监控可见状态
     *
     * @param isVisible true  不可见——可见
     *                  false 可见——不可见
     */
    protected void onFragmentVisible(boolean isVisible) {

    }

    /**
     * 子类重写，第一次可见时调用
     */
    protected void onFragmentFirstVisible() {

    }

    /**
     * 判断是否第一次可见
     */
    private void judgeIsFirst() {
        if (isFragmentFirstVisible) {
            isFragmentFirstVisible = false;
            onFragmentFirstVisible();
        }
    }

    /**
     * 添加网络请求到请求列表
     *
     * @param state
     */
    public void appendNetCall(IAsyncRequestState state) {
        mNetCalls.add(state);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        if (mPresenter != null)
            mPresenter.onDestroy();

        if (!mNetCalls.isEmpty()) {
            for (IAsyncRequestState state : mNetCalls) {
                if (state != null)
                    state.cancel();
            }
            Log.e("network", "cancel network");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
