package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_1;
import com.coopbuy.mall.ui.mainpage.model.HomeModel;
import com.coopbuy.mall.ui.mainpage.presenter.HomePresenter;
import com.coopbuy.mall.ui.mainpage.view.Home_IView;
import com.coopbuy.mall.ui.module.test.activity.TestActivity;
import com.coopbuy.mall.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 主页Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class OneFragment extends ViewPagerBaseFragment<HomePresenter, HomeModel> implements Home_IView {

    @Bind(R.id.rv_home)
    RecyclerView mRvHome;
    private DelegateAdapter mDelegateAdapter;

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
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        mRvHome.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, true);
        mDelegateAdapter.addAdapter(new HomeLayoutAdapter_1(mContext, getData1(), new LinearLayoutHelper()));
        mRvHome.setAdapter(mDelegateAdapter);
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
        } else {
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    private List getData1() {
        List list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("haha");
        }
        return list;
    }
}
