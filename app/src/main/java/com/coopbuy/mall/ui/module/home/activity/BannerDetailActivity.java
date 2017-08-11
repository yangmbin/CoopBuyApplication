package com.coopbuy.mall.ui.module.home.activity;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.HomePageDataByIdResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.home.adapter.BannerDetailLayoutAdapter_1;
import com.coopbuy.mall.ui.module.home.adapter.BannerDetailLayoutAdapter_2;
import com.coopbuy.mall.ui.module.home.model.BannerDetailModel;
import com.coopbuy.mall.ui.module.home.presenter.BannerDetailPresenter;
import com.coopbuy.mall.ui.module.home.view.BannerDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * Banner图详情
 *
 * @author ymb
 *         Create at 2017/8/10 13:59
 */
public class BannerDetailActivity extends BaseActivity<BannerDetailPresenter, BannerDetailModel> implements BannerDetail_IView {


    @Bind(R.id.rv_banner_detail)
    RecyclerView mRvBannerDetail;
    @Bind(R.id.mRefreshLayout)
    TwinklingRefreshLayout mRefreshLayout;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_banner_detail;
    }

    @Override
    public void initModel() {
        mModel = new BannerDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new BannerDetailPresenter(mContext, mModel, this);
        getBannerDetailData(false);
    }

    @Override
    public void initView() {
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        mRvBannerDetail.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRvBannerDetail.setAdapter(mDelegateAdapter);

        // 初始化下拉刷新
        ProgressLayout headerView = new ProgressLayout(mContext);
        headerView.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setHeaderView(headerView);
        mRefreshLayout.setFloatRefresh(true);
        mRefreshLayout.setEnableOverScroll(false);
        mRefreshLayout.setOnRefreshListener(mListener);
    }

    @Override
    protected void networkRetry() {
        super.networkRetry();
        getBannerDetailData(false);
    }

    private void getBannerDetailData(boolean isPullToRefresh) {
        if (getIntent().getStringExtra(IntentUtils.PARAM1) != null)
            mPresenter.getBannerDetailData(getIntent().getStringExtra(IntentUtils.PARAM1), isPullToRefresh);
        else
            finish();
    }

    private RefreshListenerAdapter mListener = new RefreshListenerAdapter() {
        @Override
        public void onRefresh(TwinklingRefreshLayout refreshLayout) {
            getBannerDetailData(true);
        }
    };

    @Override
    public void stopPullToRefreshLoading() {
        mRefreshLayout.finishRefreshing();
    }

    @Override
    public void setBannerDetailData(HomePageDataByIdResponse homePageDataByIdResponse) {
        Log.e("yangmbin", homePageDataByIdResponse.toString());
        if (homePageDataByIdResponse == null)
            return;
        setTitle(homePageDataByIdResponse.getName());
        if (homePageDataByIdResponse.getFloors().size() == 0)
            return;
        mAdapters.clear();
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRvBannerDetail.setRecycledViewPool(viewPool);
        for (int i = 0; i < homePageDataByIdResponse.getFloors().size(); i++) {
            HomePageDataByIdResponse.FloorsBean floor = homePageDataByIdResponse.getFloors().get(i);

            if (!TextUtils.isEmpty(floor.getTitleImage())) {
                List<String> tmp = new LinkedList<>();
                tmp.add(floor.getTitleImage());
                mAdapters.add(new BannerDetailLayoutAdapter_1(mContext, tmp, new SingleLayoutHelper()));
            }

            viewPool.setMaxRecycledViews(mAdapters.size(), 10);
            GridLayoutHelper gridListTwoHelper = new GridLayoutHelper(2);
            gridListTwoHelper.setAutoExpand(false);
            int gridListTwoMargin = ScreenUtils.dp2px(mContext, 5);
            gridListTwoHelper.setMargin(gridListTwoMargin, gridListTwoMargin, gridListTwoMargin, 0);
            gridListTwoHelper.setGap(gridListTwoMargin);
            gridListTwoHelper.setHGap(gridListTwoMargin);
            mAdapters.add(new BannerDetailLayoutAdapter_2(mContext, floor.getFloorItems(), gridListTwoHelper));
        }

        mDelegateAdapter.setAdapters(mAdapters);
    }
}
