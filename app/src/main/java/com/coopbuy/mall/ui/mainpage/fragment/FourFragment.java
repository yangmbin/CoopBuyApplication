package com.coopbuy.mall.ui.mainpage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.center.activity.OrderActivity;
import com.coopbuy.mall.ui.module.test.activity.NiuTestActivity;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人中心Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class FourFragment extends ViewPagerBaseFragment {
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
        } else {
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    @OnClick({R.id.test, R.id.rl_view_all_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.test:
                startActivity(new Intent(getActivity(), NiuTestActivity.class));
                break;
            case R.id.rl_view_all_order:
                IntentUtils.gotoActivity(mContext, OrderActivity.class);
                break;
            default:
                break;
        }
    }
}
