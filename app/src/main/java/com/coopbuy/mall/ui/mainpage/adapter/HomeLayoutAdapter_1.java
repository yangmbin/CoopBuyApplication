package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.youth.banner.Banner;

import java.util.List;

public class HomeLayoutAdapter_1 extends BaseDelegateAdapter<HomePageDataResponse.FloorsBean> {

    private List<HomePageDataResponse.FloorsBean> floors;

    public HomeLayoutAdapter_1(Context ctx, List<HomePageDataResponse.FloorsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        this.floors = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_1_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, HomePageDataResponse.FloorsBean item) {
        Banner banner = (Banner) holder.getView(R.id.banner);
        banner.setImages(item.getFloorItems()).setImageLoader(new BannerImageLoader()).start();
    }
}
