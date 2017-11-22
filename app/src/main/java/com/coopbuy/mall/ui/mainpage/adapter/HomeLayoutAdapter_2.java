package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.home.activity.CategoryActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeLayoutAdapter_2 extends BaseDelegateAdapter<HomeFloorResponse.FloorItemsBean> {


    public HomeLayoutAdapter_2(Context ctx, List<HomeFloorResponse.FloorItemsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_2_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final HomeFloorResponse.FloorItemsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Uri.parse(item.getImageUrl()));
        holder.getTextView(R.id.name).setText(item.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 进入分类
                if (item.getType() == 2)
                    IntentUtils.gotoActivity(mContext, CategoryActivity.class);
            }
        });
    }
}
