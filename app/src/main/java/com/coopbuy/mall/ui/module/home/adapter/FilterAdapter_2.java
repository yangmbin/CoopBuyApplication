package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class FilterAdapter_2 extends BaseDelegateAdapter<SearchResultResponse.FacetResultsBean.StatisticsBean> {

    // 当前选择的项
    private int mCurrentSelected = -1;

    private List<SearchResultResponse.FacetResultsBean.StatisticsBean> mList;
    private SearchResultResponse.FacetResultsBean mFacetResultsBean;

    public FilterAdapter_2(Context ctx, SearchResultResponse.FacetResultsBean facetResultsBean, List<SearchResultResponse.FacetResultsBean.StatisticsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        mFacetResultsBean = facetResultsBean;
        mList = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_2_filter;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, final int position, final SearchResultResponse.FacetResultsBean.StatisticsBean item) {
        TextView category = holder.getTextView(R.id.category);
        category.setText(item.getFriendlyName());
        if (position == mCurrentSelected) {
            category.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
            category.setBackgroundResource(R.drawable.shape_orange_1_no_solid_bg);
        } else {
            category.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
            category.setBackgroundResource(R.drawable.shape_gray_2_no_solid_bg);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentSelected = position;
                notifyDataSetChanged();
            }
        });
    }

    public int getmCurrentSelected() {
        return mCurrentSelected;
    }

    public void setmCurrentSelected(int mCurrentSelected) {
        this.mCurrentSelected = mCurrentSelected;
    }

    public SearchResultResponse.FacetResultsBean.StatisticsBean getCurrentItem() {
        return mList.get(mCurrentSelected);
    }

    public SearchResultResponse.FacetResultsBean getmFacetResultsBean() {
        return mFacetResultsBean;
    }

}
