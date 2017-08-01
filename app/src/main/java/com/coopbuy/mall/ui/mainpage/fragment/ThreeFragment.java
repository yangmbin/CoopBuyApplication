package com.coopbuy.mall.ui.mainpage.fragment;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;

/**
 * 便民服务Fragment
 * @author ymb
 * Create at 2017/7/25 10:23
 */
public class ThreeFragment extends ViewPagerBaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_three;
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
//            Log.e("yangmbin", "3可见了");
        } else {
//            Log.e("yangmbin", "3消失了");
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
//        Log.e("yangmbin", "3第一次可见");
    }
}
