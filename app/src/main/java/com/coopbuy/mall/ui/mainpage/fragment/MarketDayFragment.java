package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_1;
import com.coopbuy.mall.ui.mainpage.adapter.MarketLayoutAdapter_2;

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

        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }
}
