package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.fragment.HomeFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeLayoutAdapter_0 extends BaseDelegateAdapter<HomeFloorResponse> {

    public HomeLayoutAdapter_0(Context ctx, List<HomeFloorResponse> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_0_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, HomeFloorResponse item) {
        if (item.isIsShowTitle()) {
            holder.getTextView(R.id.title).setVisibility(View.VISIBLE);
            holder.getView(R.id.image).setVisibility(View.GONE);
            holder.getTextView(R.id.title).setText(item.getName());
        } else {
            holder.getTextView(R.id.title).setVisibility(View.GONE);
            if (TextUtils.isEmpty(item.getTitleImage()))
                holder.getView(R.id.image).setVisibility(View.GONE);
            else {
                holder.getView(R.id.image).setVisibility(View.VISIBLE);
                ((SimpleDraweeView) holder.getView(R.id.image)).setImageURI(Uri.parse(item.getTitleImage()));
            }
        }

        // 分割符
        String key = item.getTemplateKey();
        if (key.equals(HomeFragment.LAYOUT_TYPE_1) || key.equals(HomeFragment.LAYOUT_TYPE_2) ||
                key.equals(HomeFragment.LAYOUT_TYPE_3) || key.equals(HomeFragment.LAYOUT_TYPE_4)) {
            holder.getView(R.id.divider).setVisibility(View.GONE);
        } else {
            holder.getView(R.id.divider).setVisibility(View.VISIBLE);
        }
    }
}
