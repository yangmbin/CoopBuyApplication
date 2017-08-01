package com.coopbuy.mall.ui.mainpage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.test.TestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人中心Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class FourFragment1 extends ViewPagerBaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_four;
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
            Log.e("yangmbin", "4可见了");
        } else {
            Log.e("yangmbin", "4消失了");
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        Log.e("yangmbin", "4第一次可见");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.test)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), TestActivity.class));
    }
}
