package com.coopbuy.mall.ui.mainpage.fragment;

import android.util.Log;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.test.activity.TestActivity;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.OnClick;

/**
 * 主页Fragment
 * @author ymb
 * Create at 2017/7/25 10:23
 */
public class OneFragment extends ViewPagerBaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one;
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

    @OnClick({R.id.jump_test})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.jump_test:
                IntentUtils.gotoActivity(mContext, TestActivity.class);
                break;
        }
    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        super.onFragmentVisible(isVisible);
        if (isVisible) {
            Log.e("yangmbin", "1可见了");
        } else {
            Log.e("yangmbin", "1消失了");
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        Log.e("yangmbin", "1第一次可见");
    }
}
