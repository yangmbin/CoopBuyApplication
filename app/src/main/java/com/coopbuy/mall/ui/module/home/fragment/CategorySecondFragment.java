package com.coopbuy.mall.ui.module.home.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.api.request.SearchRequest;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.bean.CategoryIntentData;
import com.coopbuy.mall.ui.module.home.activity.CategorySecondActivity;
import com.coopbuy.mall.ui.module.home.adapter.CategorySecondAdapter;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_1;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_2;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_3;
import com.coopbuy.mall.ui.module.home.model.SearchResultModel;
import com.coopbuy.mall.ui.module.home.presenter.SearchResultPresenter;
import com.coopbuy.mall.ui.module.home.view.SearchResult_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class CategorySecondFragment extends ViewPagerBaseFragment<SearchResultPresenter, SearchResultModel> implements SearchResult_IView, OnRefreshLoadmoreListener {

    @Bind(R.id.categorySecondList)
    RecyclerView categorySecondList;
    @Bind(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.sale_count)
    TextView saleCount;
    @Bind(R.id.sale_price)
    TextView salePrice;
    @Bind(R.id.sale_price_icon)
    ImageView salePriceIcon;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    private CategoryIntentData.Item mCategoryIntentDataItem; // 当前Fragment需要加载的CategoryId，父级页面传递过来
    private int mCurrentPage = 1; // 当前页
    private int mOrderMode = 0; // 排序方式（0=默认，1=销量升序，2=销量降序，3=单价升序，4=单价降序）
    public List<SearchRequest.FiltersBean> mFilterList = new ArrayList<>(); // 筛选条件
    private SearchResultResponse mSearchResultResponse;
    private CategorySecondActivity mCategorySecondActivity; // 父Activity

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category_second;
    }

    @Override
    public void initModel() {
        mModel = new SearchResultModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new SearchResultPresenter(mContext, mModel, this);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        getSearchResult(SearchResultPresenter.LOAD_TYPE_3);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        getSearchResult(SearchResultPresenter.LOAD_TYPE_2);
    }

    @Override
    protected void onFragmentFirstVisible() {
        mCategoryIntentDataItem = (CategoryIntentData.Item) getArguments().getSerializable(IntentUtils.DATA);
        getSearchResult(SearchResultPresenter.LOAD_TYPE_1);
    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        if (isVisible) {
            // 设置抽屉数据
            setDrawerData();
        }
    }

    @Override
    protected void networkRetry() {
        getSearchResult(SearchResultPresenter.LOAD_TYPE_1);
    }

    @Override
    protected void initView() {
        // 初始化列表
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        categorySecondList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        categorySecondList.setAdapter(mDelegateAdapter);

        // 初始化上拉下拉监听
        mRefreshLayout.setOnRefreshLoadmoreListener(this);

        // 父Activity
        mCategorySecondActivity = (CategorySecondActivity) mContext;
    }

    @OnClick({R.id.openDrawer, R.id.order_by_sale_count_btn, R.id.order_by_price_btn})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.openDrawer:
                ((CategorySecondActivity) mContext).openDrawer();
                break;
            // 点击销量
            case R.id.order_by_sale_count_btn:
                mOrderMode = 2;
                saleCount.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
                salePrice.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
                salePriceIcon.setImageResource(R.mipmap.icon_normal_price);
                getSearchResult(SearchResultPresenter.LOAD_TYPE_4);
                break;
            // 点击价格
            case R.id.order_by_price_btn:
                salePrice.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
                saleCount.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
                if (mOrderMode == 3) {
                    mOrderMode = 4;
                    salePriceIcon.setImageResource(R.mipmap.icon_downward_price);
                } else if (mOrderMode == 4) {
                    mOrderMode = 3;
                    salePriceIcon.setImageResource(R.mipmap.icon_upward_price);
                } else {
                    mOrderMode = 3;
                    salePriceIcon.setImageResource(R.mipmap.icon_upward_price);
                }
                getSearchResult(SearchResultPresenter.LOAD_TYPE_4);
                break;
        }
    }

    /**
     * 获取搜索结果
     *
     * @param loadType
     */
    public void getSearchResult(int loadType) {
        if (loadType == SearchResultPresenter.LOAD_TYPE_3)
            mCurrentPage += 1;
        else
            mCurrentPage = 1;

        SearchRequest request = new SearchRequest();
        request.setSearchKeyword("");
        request.setCurrentPage(mCurrentPage);
        request.setOrderMode(mOrderMode);

        // 分类筛选条件
        SearchRequest.FiltersBean filtersBean = new SearchRequest.FiltersBean();
        filtersBean.setFieldName(mCategoryIntentDataItem.getCategoryName());
        filtersBean.setValue(mCategoryIntentDataItem.getCategoryId() + "");
        mFilterList.add(filtersBean);

        request.setFilters(mFilterList);
        mPresenter.getSearchResult(request, loadType);
    }

    @Override
    public void setSearchResult(SearchResultResponse searchResultResponse, int loadType) {
        // 保存返回数据
        mSearchResultResponse = searchResultResponse;

        if (loadType != SearchResultPresenter.LOAD_TYPE_3)
            mAdapters.clear();

        LinearLayoutHelper helper = new LinearLayoutHelper();
        mAdapters.add(new CategorySecondAdapter(mContext, searchResultResponse.getResult().getItems(), helper));

        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();

        // 设置抽屉数据
        setDrawerData();
    }

    @Override
    public void stopRefreshLayoutLoading() {
        if (mRefreshLayout != null) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.finishLoadmore();
        }
    }

    /**
     * 设置抽屉的数据，每次fragment切换都需要重新设置，注意第一次加载的时候也需要
     */
    private void setDrawerData() {
        if (mSearchResultResponse == null)
            return;

        // 抽屉
        mCategorySecondActivity.mAdapters.clear();
        mCategorySecondActivity.totalCount.setText(mSearchResultResponse.getResult().getTotalRows() + "");
        for (int i = 0; i < mSearchResultResponse.getFacetResults().size(); i++) {
            //1
            List<SearchResultResponse.FacetResultsBean> list_1 = new ArrayList();
            list_1.add(mSearchResultResponse.getFacetResults().get(i));
            mCategorySecondActivity.mAdapters.add(new FilterAdapter_1(mContext, list_1, new SingleLayoutHelper()));

            //2
            GridLayoutHelper helper_2 = new GridLayoutHelper(3);
            helper_2.setAutoExpand(false);
            helper_2.setMargin(ScreenUtils.dip2px(mContext, 15), 0, ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 25));
            helper_2.setHGap(ScreenUtils.dip2px(mContext, 17));
            helper_2.setVGap(ScreenUtils.dip2px(mContext, 15));
            List<SearchResultResponse.FacetResultsBean.StatisticsBean> list_2 = new ArrayList();
            list_2.addAll(mSearchResultResponse.getFacetResults().get(i).getStatistics());
            mCategorySecondActivity.mAdapters.add(new FilterAdapter_2(mContext, mSearchResultResponse.getFacetResults().get(i), list_2, helper_2));

            //3
            List list_3 = new ArrayList();
            list_3.add(new Object());
            mCategorySecondActivity.mAdapters.add(new FilterAdapter_3(mContext, list_3, new SingleLayoutHelper()));
        }

        mCategorySecondActivity.mDelegateAdapter.setAdapters(mCategorySecondActivity.mAdapters);
        mCategorySecondActivity.mDelegateAdapter.notifyDataSetChanged();

        // 动态计算设置RecyclerView高度
        mCategorySecondActivity.setListHeight();
    }

}
