package com.coopbuy.mall.ui.module.test.fragment;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.BallPulseView;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class TestFragment extends ViewPagerBaseFragment {

    @Bind(R.id.refresh_layout)
    TwinklingRefreshLayout mRefreshLayout;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    TestListAdapter mAdapter;
    List list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        ProgressLayout headerView = new ProgressLayout(mContext);
        headerView.setColorSchemeResources(R.color.colorPrimary);
        BallPulseView bottomView = new BallPulseView(mContext);
        bottomView.setAnimatingColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        mRefreshLayout.setHeaderView(headerView);
        mRefreshLayout.setBottomView(bottomView);
        mRefreshLayout.setFloatRefresh(true);
        mRefreshLayout.setEnableOverScroll(false);
        mRefreshLayout.setOnRefreshListener(mListener);
        list = new ArrayList();
        for (int i = 0; i < 20; i++)
            list.add(new Object());
        mAdapter = new TestListAdapter(mContext, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
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


    private RefreshListenerAdapter mListener = new RefreshListenerAdapter() {
        @Override
        public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++)
                        list.add(new Object());
                    mAdapter.notifyDataSetChanged();
                    mRefreshLayout.finishLoadmore();
                }
            }, 2000);
        }

        @Override
        public void onRefresh(TwinklingRefreshLayout refreshLayout) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    list.clear();
                    for (int i = 0; i < 20; i++)
                        list.add(new Object());
                    mAdapter.notifyDataSetChanged();
                    mRefreshLayout.finishRefreshing();
                }
            }, 2000);

        }
    };

    private class TestListAdapter extends BaseRecyclerAdapter<Object> {
        public TestListAdapter(Context ctx, List<Object> list) {
            super(ctx, list);
        }

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.item_test_list;
        }

        @Override
        protected void bindData(BaseRecyclerHolder holder, int position, Object item) {
            TextView tvTest = holder.getTextView(R.id.tv_test);
            tvTest.setText(position + " position");
        }
    }
}
