package com.coopbuy.mall.ui.module.home.activity;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.home.adapter.CategorySecondAdapter;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_1;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_2;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_3;
import com.coopbuy.mall.ui.module.home.model.SearchResultModel;
import com.coopbuy.mall.ui.module.home.presenter.SearchResultPresenter;
import com.coopbuy.mall.ui.module.home.view.SearchResult_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.coopbuy.mall.widget.navigation.SearchResultTopBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class SearchResultActivity extends BaseActivity<SearchResultPresenter, SearchResultModel> implements SearchResult_IView, OnRefreshLoadmoreListener {

    @Bind(R.id.search_result_top_bar)
    SearchResultTopBar searchResultTopBar;
    @Bind(R.id.categorySecondList)
    RecyclerView categorySecondList;
    @Bind(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.sale_count)
    TextView saleCount;
    @Bind(R.id.sale_price)
    TextView salePrice;
    @Bind(R.id.sale_price_icon)
    ImageView salePriceIcon;
    @Bind(R.id.filterList)
    RecyclerView filterList;
    @Bind(R.id.total_count)
    TextView totalCount;
    @Bind(R.id.min_price)
    EditText minPrice;
    @Bind(R.id.max_price)
    EditText maxPrice;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    private DelegateAdapter mFilterDelegateAdapter;
    private List<DelegateAdapter.Adapter> mFilterAdapters = new LinkedList<>();
    private String mSearchWord; // 搜索关键词
    private int mCurrentPage = 1; // 当前页
    private int mOrderMode = 0; // 排序方式（0=默认，1=销量升序，2=销量降序，3=单价升序，4=单价降序）
    private List<SearchRequest.FiltersBean> mFilterList = new ArrayList<>(); // 筛选条件
    private SearchResultResponse mSearchResultResponse;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search_result;
    }

    @Override
    public void initModel() {
        mModel = new SearchResultModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new SearchResultPresenter(mContext, mModel, this);
        getSearchResult(SearchResultPresenter.LOAD_TYPE_1);
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
    protected void networkRetry() {
        getSearchResult(SearchResultPresenter.LOAD_TYPE_1);
    }

    @Override
    public void initView() {
        // 保存关键词
        mSearchWord = getIntent().getStringExtra(IntentUtils.PARAM1);
        searchResultTopBar.setSearchText(mSearchWord);

        // 初始化列表
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        categorySecondList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        categorySecondList.setAdapter(mDelegateAdapter);

        // 初始化上拉下拉监听
        mRefreshLayout.setOnRefreshLoadmoreListener(this);

        /** ============================================================*/
        // 筛选列表
        VirtualLayoutManager filterManager = new VirtualLayoutManager(mContext) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        filterList.setLayoutManager(filterManager);
        mFilterDelegateAdapter = new DelegateAdapter(filterManager, false);
        filterList.setAdapter(mFilterDelegateAdapter);

    }


    @Override
    public void stopRefreshLayoutLoading() {
        if (mRefreshLayout != null) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.finishLoadmore();
        }
    }

    @OnClick({R.id.order_by_sale_count_btn, R.id.order_by_price_btn, R.id.openDrawer, R.id.closeDrawer, R.id.reset, R.id.confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
            // 打开抽屉
            case R.id.openDrawer:
                openDrawer();
                break;
            // 关闭抽屉
            case R.id.closeDrawer:
                closeDrawer();
                break;
            // 抽屉重置
            case R.id.reset:
                drawerReset();
                break;
            // 抽屉确认
            case R.id.confirm:
                drawerConfirm();
                break;
        }
    }

    /**
     * 获取搜索结果
     *
     * @param loadType
     */
    private void getSearchResult(int loadType) {
        if (loadType == SearchResultPresenter.LOAD_TYPE_3)
            mCurrentPage += 1;
        else
            mCurrentPage = 1;

        SearchRequest request = new SearchRequest();
        request.setSearchKeyword(mSearchWord);
        request.setCurrentPage(mCurrentPage);
        request.setOrderMode(mOrderMode);
        request.setFilters(mFilterList);
        mPresenter.getSearchResult(request, loadType);
    }

    /**
     * 设置网络返回数据
     *
     * @param searchResultResponse
     * @param loadType
     */
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

        // 抽屉
        mFilterAdapters.clear();
        totalCount.setText(searchResultResponse.getResult().getTotalRows() + "");
        for (int i = 0; i < searchResultResponse.getFacetResults().size(); i++) {
            //1
            List<SearchResultResponse.FacetResultsBean> list_1 = new ArrayList();
            list_1.add(searchResultResponse.getFacetResults().get(i));
            mFilterAdapters.add(new FilterAdapter_1(mContext, list_1, new SingleLayoutHelper()));

            //2
            GridLayoutHelper helper_2 = new GridLayoutHelper(3);
            helper_2.setAutoExpand(false);
            helper_2.setMargin(ScreenUtils.dip2px(mContext, 15), 0, ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 25));
            helper_2.setHGap(ScreenUtils.dip2px(mContext, 17));
            helper_2.setVGap(ScreenUtils.dip2px(mContext, 15));
            List<SearchResultResponse.FacetResultsBean.StatisticsBean> list_2 = new ArrayList();
            list_2.addAll(searchResultResponse.getFacetResults().get(i).getStatistics());
            mFilterAdapters.add(new FilterAdapter_2(mContext, searchResultResponse.getFacetResults().get(i), list_2, helper_2));

            //3
            List list_3 = new ArrayList();
            list_3.add(new Object());
            mFilterAdapters.add(new FilterAdapter_3(mContext, list_3, new SingleLayoutHelper()));
        }

        mFilterDelegateAdapter.setAdapters(mFilterAdapters);
        mFilterDelegateAdapter.notifyDataSetChanged();

        // 动态计算设置RecyclerView高度
        setListHeight();
    }

    /**
     * 关闭抽屉
     */
    private void closeDrawer() {
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }

    /**
     * 打开抽屉
     */
    public void openDrawer() {
        drawerLayout.openDrawer(Gravity.RIGHT);
    }

    /**
     * 动态计算设置RecyclerView高度
     */
    private void setListHeight() {
        int measureWidth = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        int measureHeight = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        filterList.measure(measureWidth, measureHeight);
        int height = filterList.getMeasuredHeight();
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) filterList.getLayoutParams();
        params.height = height;
        filterList.setLayoutParams(params);
    }

    /**
     * 抽屉重置
     */
    private void drawerReset() {
        minPrice.setText("");
        maxPrice.setText("");
        for (int i = 0; i < mFilterAdapters.size(); i++) {
            if (mFilterAdapters.get(i) instanceof FilterAdapter_2) {
                ((FilterAdapter_2) mFilterAdapters.get(i)).setmCurrentSelected(-1);
            }
        }
        mFilterDelegateAdapter.notifyDataSetChanged();
    }

    /**
     * 抽屉确认
     */
    private void drawerConfirm() {
        mFilterList.clear();
        for (int i = 0; i < mFilterAdapters.size(); i++) {
            if (mFilterAdapters.get(i) instanceof FilterAdapter_2) {
                int index = ((FilterAdapter_2) mFilterAdapters.get(i)).getmCurrentSelected();
                if (index != -1) {
                    SearchRequest.FiltersBean filtersBean = new SearchRequest.FiltersBean();
                    filtersBean.setFieldName(((FilterAdapter_2) mFilterAdapters.get(i)).getmFacetResultsBean().getName());
                    filtersBean.setValue(((FilterAdapter_2) mFilterAdapters.get(i)).getCurrentItem().getName());
                    mFilterList.add(filtersBean);
                }
            }
        }
        getSearchResult(SearchResultPresenter.LOAD_TYPE_4);
        closeDrawer();
    }

}
