package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.ApplyRefundGoodsListAdapter;
import com.coopbuy.mall.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;


public class ApplyRefundActivity extends BaseActivity {


    @Bind(R.id.goodsList)
    RecyclerView goodsList;

    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_apply_refund;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("申请退款");
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setAutoMeasureEnabled(true);
        goodsList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        goodsList.setAdapter(mDelegateAdapter);

        // test
        LinearLayoutHelper helper = new LinearLayoutHelper();
        helper.setDividerHeight(ScreenUtils.dip2px(mContext, 2));
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        mAdapters.add(new ApplyRefundGoodsListAdapter(mContext, list, helper));

        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }

}
