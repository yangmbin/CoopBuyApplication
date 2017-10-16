package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;
import android.net.Uri;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CategoryRightAdapter_1 extends BaseDelegateAdapter<CategoryResponse.ChildrenBeanX> {

    private int pos;

    public CategoryRightAdapter_1(Context ctx, List<CategoryResponse.ChildrenBeanX> list, LayoutHelper mLayoutHelper, int pos) {
        super(ctx, list, mLayoutHelper);
        this.pos = pos;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_1_category_right;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final CategoryResponse.ChildrenBeanX item) {
        ((SimpleDraweeView) holder.getView(R.id.image)).setImageURI(Uri.parse(item.getImageUrl()));
        if (position == 0)
            holder.itemView.setTag(pos);
    }
}
