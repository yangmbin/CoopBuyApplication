package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.bean.CategoryIntentData;
import com.coopbuy.mall.ui.module.home.activity.CategorySecondActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class CategoryRightAdapter_4 extends BaseDelegateAdapter<CategoryResponse.ChildrenBeanX.ChildrenBean> {

    private CategoryResponse.ChildrenBeanX mChildrenBeanX;

    public CategoryRightAdapter_4(Context ctx, CategoryResponse.ChildrenBeanX childrenBeanX, List<CategoryResponse.ChildrenBeanX.ChildrenBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        mChildrenBeanX = childrenBeanX;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_4_category_right;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, final int position, final CategoryResponse.ChildrenBeanX.ChildrenBean item) {
        ((SimpleDraweeView) holder.getView(R.id.image)).setImageURI(Uri.parse(item.getImageUrl()));
        holder.getTextView(R.id.name).setText(item.getName());

        // 点击三级分类
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoryIntentData categoryIntentData = new CategoryIntentData();
                categoryIntentData.setCurrentIndex(position + 1);
                List<CategoryIntentData.Item> itemList = new ArrayList<>();

                // 第一项“全部”，二级分类
                CategoryIntentData.Item firstItem = new CategoryIntentData.Item();
                firstItem.setCategoryId(mChildrenBeanX.getCategoryId());
                firstItem.setCategoryName("SecondCategoryId");
                firstItem.setFriendlyName(mChildrenBeanX.getName());
                itemList.add(firstItem);
                // 三级分类
                for (int i = 0; i < mChildrenBeanX.getChildren().size(); i++) {
                    CategoryIntentData.Item itemData = new CategoryIntentData.Item();
                    itemData.setCategoryId(mChildrenBeanX.getChildren().get(i).getCategoryId());
                    itemData.setCategoryName("CategoryId");
                    itemData.setFriendlyName(mChildrenBeanX.getChildren().get(i).getName());
                    itemList.add(itemData);
                }
                categoryIntentData.setItemList(itemList);

                IntentUtils.gotoActivity(mContext, CategorySecondActivity.class, categoryIntentData);
            }
        });
    }
}
