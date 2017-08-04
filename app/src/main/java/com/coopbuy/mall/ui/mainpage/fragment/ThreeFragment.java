package com.coopbuy.mall.ui.mainpage.fragment;

import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.utils.ToastUtils;

import butterknife.OnClick;

/**
 * 便民服务Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
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
        } else {
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    @OnClick(R.id.ll_phone_recharge)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.ll_phone_recharge:
                ToastUtils.toastShort("话费充值");
                break;
            default:
                break;
        }
    }
}
