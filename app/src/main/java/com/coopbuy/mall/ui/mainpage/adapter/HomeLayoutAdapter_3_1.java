package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class HomeLayoutAdapter_3_1 extends BaseDelegateAdapter<HomeFloorResponse> {


    public HomeLayoutAdapter_3_1(Context ctx, List<HomeFloorResponse> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_3_1_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final HomeFloorResponse item) {
        Banner banner = (Banner) holder.getView(R.id.banner);
        List list = new ArrayList();
        for (int i = 0; i < item.getFloorItems().size(); i++)
            list.add(item.getFloorItems().get(i).getImageUrl());
        banner.setImages(list).setImageLoader(new BannerImageLoader()).start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
            }
        });
    }
}
