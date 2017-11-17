package com.coopbuy.mall.ui.module.home.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.api.request.SearchRequest;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.home.activity.ShopDetailActivity;
import com.coopbuy.mall.ui.module.home.adapter.ShopDetailAdapter_4;
import com.coopbuy.mall.ui.module.home.model.SearchResultModel;
import com.coopbuy.mall.ui.module.home.presenter.SearchResultPresenter;
import com.coopbuy.mall.ui.module.home.view.SearchResult_IView;
import com.coopbuy.mall.utils.ScreenUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static com.coopbuy.mall.R.id.mRecycleView;

/**
 * 店铺详情Fragment2
 *
 * @author ymb
 *         Create at 2017/7/25 10:23
 */
public class ShopDetailFragment_2 extends ViewPagerBaseFragment<SearchResultPresenter, SearchResultModel> implements SearchResult_IView, OnRefreshLoadmoreListener {

    @Bind(mRecycleView)
    RecyclerView mGoodsList;
    @Bind(R.id.topLayout)
    LinearLayout topLayout;
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

    private int mCurrentPage = 1; // 当前页
    private int mOrderMode = 0; // 排序方式（0=默认，1=销量升序，2=销量降序，3=单价升序，4=单价降序）
    private List<SearchRequest.FiltersBean> mFilterList = new ArrayList<>(); // 筛选条件
    private SearchResultResponse mSearchResultResponse;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop_detail_2;
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
    protected void initView() {
        // 初始化列表
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mGoodsList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mGoodsList.setAdapter(mDelegateAdapter);

        // 初始化上拉下拉监听
        mRefreshLayout.setOnRefreshLoadmoreListener(this);
    }

    @Override
    protected void onFragmentFirstVisible() {
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
    public void stopRefreshLayoutLoading() {
        if (mRefreshLayout != null) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.finishLoadmore();
        }
    }


    @OnClick({R.id.order_by_sale_count_btn, R.id.order_by_price_btn})
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
        request.setSearchKeyword("");
        request.setCurrentPage(mCurrentPage);
        request.setOrderMode(mOrderMode);

        SearchRequest.FiltersBean filtersBean = new SearchRequest.FiltersBean();
        filtersBean.setFieldName("ShopId");
        filtersBean.setValue(((ShopDetailActivity) mContext).getShopId() + "");
        mFilterList.add(filtersBean);

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

        GridLayoutHelper helper = new GridLayoutHelper(2);
        helper.setAutoExpand(false);
        int dimen = ScreenUtils.dip2px(mContext, 6);
        helper.setGap(dimen);
        helper.setMargin(dimen, dimen, dimen, dimen);
        mAdapters.add(new ShopDetailAdapter_4(mContext, searchResultResponse.getResult().getItems(), helper));

        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();

        // 动态设置列表高度
        setListHeight();
    }

    /**
     * 设置列表高度
     */
    private void setListHeight() {
        int measureWidth = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        int measureHeight = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        topLayout.measure(measureWidth, measureHeight);
        int height = topLayout.getMeasuredHeight() + ScreenUtils.dip2px(mContext, 110 + 80);

        ((ShopDetailActivity) mContext).setViewPagerHeight(height);
    }
}
