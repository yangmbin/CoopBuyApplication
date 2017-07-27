package com.coopbuy.mall.ui.mainpage.fragment;

import android.util.Log;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.utils.ToastUtils;

/**
 * 分类Fragment
 * @author ymb
 * Create at 2017/7/25 10:23
 */
public class TwoFragment extends ViewPagerBaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        super.onFragmentVisible(isVisible);
        if (isVisible) {
            Log.e("yangmbin", "2可见了");
        } else {
            Log.e("yangmbin", "2消失了");
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        Log.e("yangmbin", "2第一次可见");

        showNetErrorLayout();
    }

    @Override
    protected void networkRetry() {
        super.networkRetry();
        ToastUtils.textToast(mContext, "reload");
    }
}
