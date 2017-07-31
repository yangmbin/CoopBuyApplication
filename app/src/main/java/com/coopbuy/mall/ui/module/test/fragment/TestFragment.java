package com.coopbuy.mall.ui.module.test.fragment;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;

public class TestFragment extends ViewPagerBaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
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
        } else {
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }
}
