package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.graphics.Color;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.ScreenUtils;

import java.util.List;

import cn.iwgang.simplifyspan.SimplifySpanBuild;
import cn.iwgang.simplifyspan.other.SpecialGravity;
import cn.iwgang.simplifyspan.unit.SpecialLabelUnit;

public class MarketLayoutAdapter_7 extends BaseDelegateAdapter<Object> {

    public MarketLayoutAdapter_7(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_7_market;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, Object item) {
        SimplifySpanBuild simplifySpanBuild = new SimplifySpanBuild();
        simplifySpanBuild
                .append(new SpecialLabelUnit("紫云专享", Color.WHITE, ScreenUtils.dip2px(mContext, 11), 0xFFAA54DC)
                .setLabelBgRadius(0)
                .setPadding(ScreenUtils.dip2px(mContext, 5))
                .setGravity(SpecialGravity.CENTER))
                .append(" " + "商品名称商品名称商品名称商品名称商品名称商品名称");
        holder.getTextView(R.id.goods_name).setText(simplifySpanBuild.build());
    }
}
