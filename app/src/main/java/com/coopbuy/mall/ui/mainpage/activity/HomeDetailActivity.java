package com.coopbuy.mall.ui.mainpage.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.HomeDetailFloorResponse;
import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_0;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_1;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_2;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_3_1;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_3_2;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_4;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_5;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_6;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_7_1;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_7_2;
import com.coopbuy.mall.ui.mainpage.adapter.HomeLayoutAdapter_8;
import com.coopbuy.mall.ui.mainpage.fragment.HomeFragment;
import com.coopbuy.mall.ui.mainpage.model.HomeDetailModel;
import com.coopbuy.mall.ui.mainpage.presenter.HomeDetailPresenter;
import com.coopbuy.mall.ui.mainpage.view.HomeDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

public class HomeDetailActivity extends BaseActivity<HomeDetailPresenter, HomeDetailModel> implements HomeDetail_IView, OnRefreshListener {

    @Bind(R.id.rv_home_detail)
    RecyclerView mRvHomeDetail;
    @Bind(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_detail;
    }

    @Override
    public void initModel() {
        mModel = new HomeDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new HomeDetailPresenter(mContext, mModel, this);
        mPresenter.getHomeDetailData(getIntent().getIntExtra(IntentUtils.PARAM1, 0), false);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.getHomeDetailData(getIntent().getIntExtra(IntentUtils.PARAM1, 0), true);
    }

    @Override
    protected void networkRetry() {
        mPresenter.getHomeDetailData(getIntent().getIntExtra(IntentUtils.PARAM1, 0), false);
    }

    @Override
    public void initView() {
        setTitle("");
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        mRvHomeDetail.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRvHomeDetail.setAdapter(mDelegateAdapter);
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void stopPullToRefreshLoading() {
        if (mRefreshLayout != null)
            mRefreshLayout.finishRefresh();
    }

    @Override
    public void setHomeDetailData(HomeDetailFloorResponse homeDetailFloorResponse) {
        // 设置标题
        setTitle(homeDetailFloorResponse.getName());

        mAdapters.clear();
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRvHomeDetail.setRecycledViewPool(viewPool);

        for (int i = 0; i < homeDetailFloorResponse.getFloorList().size(); i++) {
            HomeFloorResponse item = homeDetailFloorResponse.getFloorList().get(i);
            // 头部标题（判断一下，如果布局是空的，下拉刷新失效）
            List list_0 = new ArrayList();
            list_0.add(item);
            if (item.isIsShowTitle() || !TextUtils.isEmpty(item.getTitleImage()))
                mAdapters.add(new HomeLayoutAdapter_0(mContext, list_0, new SingleLayoutHelper()));

            switch (item.getTemplateKey()) {
                case HomeFragment.LAYOUT_TYPE_1:
                    List list_1 = new ArrayList<>();
                    list_1.add(item);
                    mAdapters.add(new HomeLayoutAdapter_1(mContext, list_1, new SingleLayoutHelper()));
                    break;
                case HomeFragment.LAYOUT_TYPE_2:
                    GridLayoutHelper helper_2 = new GridLayoutHelper(5);
                    helper_2.setPaddingTop(ScreenUtils.dip2px(mContext, 20));
                    helper_2.setPaddingBottom(ScreenUtils.dip2px(mContext, 22));
                    helper_2.setVGap(ScreenUtils.dip2px(mContext, 20));
                    helper_2.setBgColor(ContextCompat.getColor(mContext, R.color.white));
                    helper_2.setAutoExpand(false);
                    mAdapters.add(new HomeLayoutAdapter_2(mContext, item.getFloorItems(), helper_2));
                    break;
                case HomeFragment.LAYOUT_TYPE_3:
                    List list_3_1 = new ArrayList<>();
                    list_3_1.add(item);
                    mAdapters.add(new HomeLayoutAdapter_3_1(mContext, list_3_1, new SingleLayoutHelper()));
                    break;
                case HomeFragment.LAYOUT_TYPE_4:
                    List list_3_2 = new ArrayList<>();
                    list_3_2.add(item);
                    mAdapters.add(new HomeLayoutAdapter_3_2(mContext, list_3_2, new SingleLayoutHelper()));
                    break;
                case HomeFragment.LAYOUT_TYPE_5:
                    LinearLayoutHelper helper_4 = new LinearLayoutHelper();
                    helper_4.setDividerHeight(ScreenUtils.dip2px(mContext, 2));
                    mAdapters.add(new HomeLayoutAdapter_4(mContext, item.getFloorItems(), helper_4));
                    break;
                case HomeFragment.LAYOUT_TYPE_6:
                    SingleLayoutHelper helper_5 = new SingleLayoutHelper();
                    mAdapters.add(new HomeLayoutAdapter_5(mContext, item.getFloorItems(), helper_5));
                    break;
                case HomeFragment.LAYOUT_TYPE_7:
                    SingleLayoutHelper helper_6 = new SingleLayoutHelper();
                    List list_6 = new ArrayList<>();
                    list_6.add(item);
                    mAdapters.add(new HomeLayoutAdapter_6(mContext, list_6, helper_6));
                    break;
                case HomeFragment.LAYOUT_TYPE_8:
                    SingleLayoutHelper helper_7_1 = new SingleLayoutHelper();
                    List list_7_1 = new ArrayList<>();
                    list_7_1.add(item);
                    mAdapters.add(new HomeLayoutAdapter_7_1(mContext, list_7_1, helper_7_1));

                    LinearLayoutHelper helper_7_2 = new LinearLayoutHelper();
                    helper_7_2.setPaddingBottom(ScreenUtils.dip2px(mContext, 10));
                    helper_7_2.setBgColor(ContextCompat.getColor(mContext, R.color.white));
                    List list_7_2 = new ArrayList();
                    list_7_2.addAll(item.getFloorItems().subList(1, item.getFloorItems().size()));
                    mAdapters.add(new HomeLayoutAdapter_7_2(mContext, list_7_2, helper_7_2));
                    break;
                case HomeFragment.LAYOUT_TYPE_9:
                    GridLayoutHelper helper_8 = new GridLayoutHelper(2);
                    helper_8.setAutoExpand(false);
                    helper_8.setGap(ScreenUtils.dip2px(mContext, 15));
                    helper_8.setPadding(ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 15));
                    helper_8.setBgColor(ContextCompat.getColor(mContext, R.color.white));
                    mAdapters.add(new HomeLayoutAdapter_8(mContext, item.getFloorItems(), helper_8));
                    break;
            }
        }

        for (int i = 0; i < mAdapters.size(); i++)
            viewPool.setMaxRecycledViews(i, 10);
        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }

}
