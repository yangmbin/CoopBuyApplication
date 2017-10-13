package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class ShopDetailAdapter_3 extends BaseDelegateAdapter<Object> {

    public ShopDetailAdapter_3(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_3_shop_detail;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
        Banner banner = (Banner) holder.getView(R.id.banner);
        List list = new ArrayList();
        list.add("https://cd5n.pixabay.com/photo/2017/09/16/16/09/sea-2755908__340.jpg");
        list.add("https://cd5n.pixabay.com/photo/2017/09/09/21/55/noodles-2733636__340.jpg");
        banner.setImages(list).setImageLoader(new BannerImageLoader()).start();
    }
}
