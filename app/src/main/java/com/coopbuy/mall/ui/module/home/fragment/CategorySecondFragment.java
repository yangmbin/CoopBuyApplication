package com.coopbuy.mall.ui.module.home.fragment;

import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.home.adapter.CategorySecondAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

public class CategorySecondFragment extends ViewPagerBaseFragment {

    @Bind(R.id.categorySecondList)
    RecyclerView categorySecondList;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category_second;
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
        categorySecondList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        categorySecondList.setAdapter(mDelegateAdapter);

        //test
        LinearLayoutHelper helper = new LinearLayoutHelper();
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        mAdapters.add(new CategorySecondAdapter(mContext, list, helper));


        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }

}
