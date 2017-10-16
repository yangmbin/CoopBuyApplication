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

public class CategoryRightAdapter_4 extends BaseDelegateAdapter<CategoryResponse.ChildrenBeanX.ChildrenBean> {

    public CategoryRightAdapter_4(Context ctx, List<CategoryResponse.ChildrenBeanX.ChildrenBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_4_category_right;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final CategoryResponse.ChildrenBeanX.ChildrenBean item) {
        ((SimpleDraweeView) holder.getView(R.id.image)).setImageURI(Uri.parse(item.getImageUrl()));
        holder.getTextView(R.id.name).setText(item.getName());
    }
}
