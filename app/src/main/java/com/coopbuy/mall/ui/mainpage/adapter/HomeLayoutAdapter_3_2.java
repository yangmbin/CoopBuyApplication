package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.ArrayList;
import java.util.List;

public class HomeLayoutAdapter_3_2 extends BaseDelegateAdapter<Object> {

    private List<Object> floors;

    public HomeLayoutAdapter_3_2(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        this.floors = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_3_2_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
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
            return R.layout.list_item_3_2_home;
        }

        @Override
        protected void bindData(BaseRecyclerHolder holder, final int position, final Object item) {

        }
    }
}
