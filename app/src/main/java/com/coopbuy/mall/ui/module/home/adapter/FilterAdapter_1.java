package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class FilterAdapter_1 extends BaseDelegateAdapter<SearchResultResponse.FacetResultsBean> {

    public FilterAdapter_1(Context ctx, List<SearchResultResponse.FacetResultsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_1_filter;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final SearchResultResponse.FacetResultsBean item) {
        holder.getTextView(R.id.name).setText(item.getFriendlyName());
    }
}
