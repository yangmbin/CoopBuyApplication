package com.coopbuy.mall.ui.module.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_1;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_2;
import com.coopbuy.mall.ui.module.home.adapter.FilterAdapter_3;
import com.coopbuy.mall.ui.module.home.fragment.CategorySecondFragment;
import com.coopbuy.mall.utils.ScreenUtils;
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
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyViewPagerAdapter mAdapter;
    private final String[] mTitles = {"全部", "厨房配件", "烹饪锅具"};

    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

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

    @Override
    public void initView() {
        setTitle("厨具");
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

        //test
        //1
        List list_1 = new ArrayList();
        list_1.add(new Object());
        mAdapters.add(new FilterAdapter_1(mContext, list_1, new SingleLayoutHelper()));

        //2
        GridLayoutHelper helper_2 = new GridLayoutHelper(3);
        helper_2.setAutoExpand(false);
        helper_2.setMargin(ScreenUtils.dip2px(mContext, 15), 0, ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 25));
        helper_2.setHGap(ScreenUtils.dip2px(mContext, 17));
        helper_2.setVGap(ScreenUtils.dip2px(mContext, 15));
        List list_2 = new ArrayList();
        list_2.add(new Object());
        list_2.add(new Object());
        list_2.add(new Object());
        list_2.add(new Object());
        mAdapters.add(new FilterAdapter_2(mContext, new SearchResultResponse.FacetResultsBean(), list_2, helper_2));

        //3
        List list_3 = new ArrayList();
        list_3.add(new Object());
        mAdapters.add(new FilterAdapter_3(mContext, list_3, new SingleLayoutHelper()));


        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();

        // 动态计算设置RecyclerView高度
        setListHeight();
    }

    private void initFragment() {
        mFragments.add(new CategorySecondFragment());
        mFragments.add(new CategorySecondFragment());
        mFragments.add(new CategorySecondFragment());
    }

    private void initAdapter() {
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mViewPager, mTitles, this, mFragments);
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
     * 点击事件监听
     */
    @OnClick({R.id.closeDrawer})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.closeDrawer:
                closeDrawer();
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
}
