package com.coopbuy.mall.ui.module.home.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.home.activity.ShopDetailActivity;
import com.coopbuy.mall.ui.module.home.adapter.ShopDetailAdapter_4;
import com.coopbuy.mall.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * 店铺详情Fragment2
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class ShopDetailFragment_2 extends ViewPagerBaseFragment {

    @Bind(R.id.mRecycleView)
    RecyclerView mRecycleView;
    @Bind(R.id.topLayout)
    LinearLayout topLayout;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop_detail_2;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecycleView.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRecycleView.setAdapter(mDelegateAdapter);

        //test
        GridLayoutHelper helper = new GridLayoutHelper(2);
        helper.setAutoExpand(false);
        int dimen = ScreenUtils.dip2px(mContext, 6);
        helper.setGap(dimen);
        helper.setMargin(dimen, dimen, dimen, dimen);
        List list = new ArrayList();
        for (int i = 0; i < 12; i++)
            list.add(new Object());
        mAdapters.add(new ShopDetailAdapter_4(mContext, list, helper));

        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        // Fragment每次切换动态修改ViewPager高度
        if (isVisible) {
            int measureWidth = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
            int measureHeight = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
            topLayout.measure(measureWidth, measureHeight);
            int height = topLayout.getMeasuredHeight() + ScreenUtils.dip2px(mContext, 120);

            ((ShopDetailActivity) mContext).setViewPagerHeight(height);
        }
    }
}
