package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.ArrayList;
import java.util.List;

public class HomeLayoutAdapter_6 extends BaseDelegateAdapter<HomePageDataResponse.FloorsBean> {

    private List<HomePageDataResponse.FloorsBean.FloorItemsBean> floorItems;

    public HomeLayoutAdapter_6(Context ctx, List<HomePageDataResponse.FloorsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_6_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final HomePageDataResponse.FloorsBean item) {
        RecyclerView recyclerView = (RecyclerView) holder.getView(R.id.mRecycleView);
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        List list = new ArrayList();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        HorizontalAdapter adapter = new HorizontalAdapter(mContext, list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    class HorizontalAdapter extends BaseRecyclerAdapter<Object> {

        public HorizontalAdapter(Context ctx, List<Object> list) {
            super(ctx, list);
        }

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.list_item_6_home;
        }

        @Override
        protected void bindData(BaseRecyclerHolder holder, final int position, final Object item) {

        }
    }
}
