package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_1;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_10;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_11;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_2;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_3;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_4;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_5;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_6;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_7;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_8;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_9;
import com.coopbuy.mall.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * 赶场内部单日Fragment
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class MarketDayFragment extends ViewPagerBaseFragment {

    @Bind(R.id.rv_market_day)
    RecyclerView rvMarketDay;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    private DelegateAdapter.Adapter mAdapter_9, mAdapter_10;
    private int mCurrentTabIndex = 1; // 当前抢购Tab选中的下标

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_market_day;
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
        rvMarketDay.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        rvMarketDay.setAdapter(mDelegateAdapter);

        //test
        mAdapters.clear();
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rvMarketDay.setRecycledViewPool(viewPool);
//        viewPool.setMaxRecycledViews(i, 10);
        List<Object> decoration;

        //1
        decoration = new ArrayList();
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_1(mContext, decoration, new SingleLayoutHelper()));

        //2
        decoration = new ArrayList();
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_2(mContext, decoration, new SingleLayoutHelper()));

        //3
        decoration = new ArrayList();
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_3(mContext, decoration, new SingleLayoutHelper()));

        //4
        LinearLayoutHelper helper_4 = new LinearLayoutHelper();
        decoration = new ArrayList();
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_4(mContext, decoration, helper_4));

        //3
        decoration = new ArrayList();
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_3(mContext, decoration, new SingleLayoutHelper()));

        //5
        decoration = new ArrayList();
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_5(mContext, decoration, new SingleLayoutHelper()));

        //6
        LinearLayoutHelper helper_6 = new LinearLayoutHelper();
        helper_6.setMarginTop(ScreenUtils.dip2px(mContext, 10));
        decoration = new ArrayList();
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_6(mContext, decoration, helper_6));

        //3
        decoration = new ArrayList();
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_3(mContext, decoration, new SingleLayoutHelper()));

        //7
        GridLayoutHelper helper_7 = new GridLayoutHelper(2);
        helper_7.setAutoExpand(false);
        helper_7.setGap(ScreenUtils.dip2px(mContext, 15));
        helper_7.setPadding(ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15));
        helper_7.setBgColor(ContextCompat.getColor(mContext, R.color.white));
        decoration = new ArrayList();
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_7(mContext, decoration, helper_7));

        //8
        decoration = new ArrayList();
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_8(mContext, decoration, new SingleLayoutHelper()));

        //9 问题：设置显示隐藏，有一些不起作用。解决方法：显示隐藏用VISIBLE和INVISIBLE，不能用GONE
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(FixLayoutHelper.TOP_LEFT, 0, 0);
        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_LEAVE);
        scrollFixLayoutHelper.setMarginTop(ScreenUtils.dip2px(mContext, 8));
        List<Object> tmp = new ArrayList<>();
        tmp.add(new Object());
        mAdapter_9 = new MarketLayoutAdapter_9(this, tmp, scrollFixLayoutHelper);
        mAdapters.add(mAdapter_9);

        //10
        SingleLayoutHelper helper_10 = new SingleLayoutHelper();
        helper_10.setMarginTop(ScreenUtils.dip2px(mContext, 8));
        decoration = new ArrayList();
        decoration.add(new Object());
        mAdapter_10 = new MarketLayoutAdapter_10(this, decoration, helper_10);
        mAdapters.add(mAdapter_10);

        //11
        LinearLayoutHelper helper_11 = new LinearLayoutHelper();
        decoration = new ArrayList();
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        decoration.add(new Object());
        mAdapters.add(new MarketLayoutAdapter_11(mContext, decoration, helper_11));


        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }

    /**
     * 刷新抢购非悬浮的Tab
     */
    public void notifyAdapter_10() {
        ((MarketLayoutAdapter_10) mAdapter_10).refreshTab();
    }

    /**
     * 刷新抢购悬浮的Tab
     */
    public void notifyAdapter_9() {
        ((MarketLayoutAdapter_9) mAdapter_9).refreshTab();
    }

    public void setCurrentTabIndex(int index) {
        mCurrentTabIndex = index;
    }

    public int getCurrentTabIndex() {
        return mCurrentTabIndex;
    }
}
