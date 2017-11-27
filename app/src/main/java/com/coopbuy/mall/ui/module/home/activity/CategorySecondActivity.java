package com.coopbuy.mall.ui.module.home.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.request.SearchRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.bean.CategoryIntentData;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_2;
import com.coopbuy.mall.ui.module.home.fragment.CategorySecondFragment;
import com.coopbuy.mall.ui.module.home.presenter.SearchResultPresenter;
import com.coopbuy.mall.utils.IntentUtils;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


public class CategorySecondActivity extends BaseActivity {

    @Bind(R.id.tablayout)
    SlidingTabLayout mTabLayout;
    @Bind(R.id.tab_content)
    ViewPager mViewPager;
    @Bind(R.id.filterList)
    RecyclerView filterList;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Bind(R.id.total_count)
    public TextView totalCount;
    @Bind(R.id.min_price)
    EditText minPrice;
    @Bind(R.id.max_price)
    EditText maxPrice;
    public ArrayList<Fragment> mFragments = new ArrayList<>();
    public MyViewPagerAdapter mAdapter;
    public DelegateAdapter mDelegateAdapter;
    public List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    public CategoryIntentData mCategoryIntentData; // 保存前一个页面传递的数据


    @Override
    public int getLayoutId() {
        return R.layout.activity_category_second;
    }

    @Override
    public void initModel() {
    }

    @Override
    public void initPresenter() {

    }

    /**
     * 标题栏右边搜索按钮
     */
    @Override
    public void clickTitleBarRight() {
        IntentUtils.gotoActivity(mContext, SearchActivity.class);
    }

    @Override
    public void initView() {
        mCategoryIntentData = (CategoryIntentData) getIntent().getSerializableExtra(IntentUtils.DATA);

        setTitle(mCategoryIntentData.getItemList().get(0).getFriendlyName());
        setRightImage(R.mipmap.icon_right_search);
        initFragment();
        initAdapter();

        // 筛选列表
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        filterList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        filterList.setAdapter(mDelegateAdapter);
    }

    private void initFragment() {
        for (int i = 0; i < mCategoryIntentData.getItemList().size(); i++) {
            CategorySecondFragment categorySecondFragment = new CategorySecondFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(IntentUtils.DATA, mCategoryIntentData.getItemList().get(i));
            categorySecondFragment.setArguments(bundle);
            mFragments.add(categorySecondFragment);
        }
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mViewPager, mCategoryIntentData.getFriendlyNameList(), this, mFragments);
        mViewPager.setCurrentItem(mCategoryIntentData.getCurrentIndex());
    }

    /**
     * 动态计算设置RecyclerView高度
     */
    public void setListHeight() {
        int measureWidth = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        int measureHeight = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        filterList.measure(measureWidth, measureHeight);
        int height = filterList.getMeasuredHeight();
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) filterList.getLayoutParams();
        params.height = height;
        filterList.setLayoutParams(params);
    }

    /**
     * 点击事件监听
     */
    @OnClick({R.id.closeDrawer, R.id.reset, R.id.confirm})
    public void onViewClicked(View v) {
        switch (v.getId()) {
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
     * 抽屉重置
     */
    private void drawerReset() {
        closeDrawer();
        minPrice.setText("");
        maxPrice.setText("");
        for (int i = 0; i < mAdapters.size(); i++) {
            if (mAdapters.get(i) instanceof FilterAdapter_2) {
                ((FilterAdapter_2) mAdapters.get(i)).setmCurrentSelected(-1);
            }
        }
        mDelegateAdapter.notifyDataSetChanged();

        CategorySecondFragment currentFragment = (CategorySecondFragment) mFragments.get(mTabLayout.getCurrentTab());
        currentFragment.mOrderMode = 0;
        currentFragment.mFilterList.clear();
        currentFragment.saleCount.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
        currentFragment.salePrice.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
        currentFragment.salePriceIcon.setImageResource(R.mipmap.icon_normal_price);
        currentFragment.getSearchResult(SearchResultPresenter.LOAD_TYPE_4);
    }

    /**
     * 抽屉确认
     */
    private void drawerConfirm() {
        // 当前可见的Fragment
        CategorySecondFragment currentFragment = (CategorySecondFragment) mFragments.get(mTabLayout.getCurrentTab());

        currentFragment.mFilterList.clear();
        for (int i = 0; i < mAdapters.size(); i++) {
            if (mAdapters.get(i) instanceof FilterAdapter_2) {
                int index = ((FilterAdapter_2) mAdapters.get(i)).getmCurrentSelected();
                if (index != -1) {
                    SearchRequest.FiltersBean filtersBean = new SearchRequest.FiltersBean();
                    filtersBean.setFieldName(((FilterAdapter_2) mAdapters.get(i)).getmFacetResultsBean().getName());
                    filtersBean.setValue(((FilterAdapter_2) mAdapters.get(i)).getCurrentItem().getName());
                    currentFragment.mFilterList.add(filtersBean);
                }
            }
        }
        currentFragment.getSearchResult(SearchResultPresenter.LOAD_TYPE_4);
        closeDrawer();
    }

}
