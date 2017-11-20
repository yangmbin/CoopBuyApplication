package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class CategoryRightAdapter_2 extends BaseDelegateAdapter<CategoryResponse> {

    private int pos;

    public CategoryRightAdapter_2(Context ctx, List<CategoryResponse> list, LayoutHelper mLayoutHelper, int pos) {
        super(ctx, list, mLayoutHelper);
        this.pos = pos;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_2_category_right;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final CategoryResponse item) {
        holder.getTextView(R.id.category_name).setText(item.getName());
        holder.itemView.setTag(pos);

        // 设置背景色
        if (pos % 2 == 0) {
            holder.getView(R.id.layout_bg).setBackgroundColor(ContextCompat.getColor(mContext, R.color.blue_1));
        } else {
            holder.getView(R.id.layout_bg).setBackgroundColor(ContextCompat.getColor(mContext, R.color.red_7));
        }
    }
}
