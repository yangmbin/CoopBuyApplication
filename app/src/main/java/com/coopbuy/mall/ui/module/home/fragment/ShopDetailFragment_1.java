package com.coopbuy.mall.ui.module.home.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.home.activity.ShopDetailActivity;
import com.coopbuy.mall.ui.module.home.adapter.ShopDetailAdapter_1;
import com.coopbuy.mall.ui.module.home.adapter.ShopDetailAdapter_2;
import com.coopbuy.mall.ui.module.home.adapter.ShopDetailAdapter_3;
import com.coopbuy.mall.ui.module.home.adapter.ShopDetailAdapter_4;
import com.coopbuy.mall.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * 店铺详情Fragment1
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class ShopDetailFragment_1 extends ViewPagerBaseFragment {

    @Bind(R.id.mRecycleView)
    RecyclerView mRecycleView;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop_detail_1;
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
        //1
        List list_1 = new ArrayList();
        list_1.add(new Object());
        mAdapters.add(new ShopDetailAdapter_1(mContext, list_1, new SingleLayoutHelper()));

        //2
        List list_2 = new ArrayList();
        list_2.add(new Object());
        mAdapters.add(new ShopDetailAdapter_2(mContext, list_2, new SingleLayoutHelper()));

        //3
        List list_3 = new ArrayList();
        list_3.add(new Object());
        mAdapters.add(new ShopDetailAdapter_3(mContext, list_3, new SingleLayoutHelper()));

        //4
        GridLayoutHelper helper_4 = new GridLayoutHelper(2);
        helper_4.setAutoExpand(false);
        int dimen = ScreenUtils.dip2px(mContext, 6);
        helper_4.setGap(dimen);
        helper_4.setMargin(dimen, dimen, dimen, dimen);
        List list_4 = new ArrayList();
        for (int i = 0; i < 6; i++)
            list_4.add(new Object());
        mAdapters.add(new ShopDetailAdapter_4(mContext, list_4, helper_4));

        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        // Fragment每次切换动态修改ViewPager高度
        if (isVisible) {
            int measureWidth = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
            int measureHeight = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
            mRecycleView.measure(measureWidth, measureHeight);
            int height = mRecycleView.getMeasuredHeight() + ScreenUtils.dip2px(mContext, 60);

            ((ShopDetailActivity) mContext).setViewPagerHeight(height);
        }
    }
}
