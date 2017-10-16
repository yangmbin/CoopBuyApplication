package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class CategoryRightAdapter_3 extends BaseDelegateAdapter<CategoryResponse.ChildrenBeanX> {

    public CategoryRightAdapter_3(Context ctx, List<CategoryResponse.ChildrenBeanX> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_3_category_right;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final CategoryResponse.ChildrenBeanX item) {
        holder.getTextView(R.id.category_name).setText(item.getName());
    }
}
