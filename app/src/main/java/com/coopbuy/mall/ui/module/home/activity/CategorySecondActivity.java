package com.coopbuy.mall.ui.module.home.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyViewPagerAdapter;
import com.coopbuy.mall.ui.module.home.adapter.CategorySecondAdapter;
import com.coopbuy.mall.ui.module.home.fragment.CategorySecondFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;


public class CategorySecondActivity extends BaseActivity {

    @Bind(R.id.tablayout)
    SlidingTabLayout mTabLayout;
    @Bind(R.id.tab_content)
    ViewPager mViewPager;
    @Bind(R.id.filterList)
    RecyclerView filterList;
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
        LinearLayoutHelper helper = new LinearLayoutHelper();
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        mAdapters.add(new CategorySecondAdapter(mContext, list, helper));


        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
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

}
