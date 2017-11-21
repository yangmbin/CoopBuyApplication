package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class HomeLayoutAdapter_3_1 extends BaseDelegateAdapter<Object> {

    private List<Object> floors;

    public HomeLayoutAdapter_3_1(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        this.floors = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_3_1_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
        Banner banner = (Banner) holder.getView(R.id.banner);
        List list = new ArrayList();
        list.add("https://cd5n.pixabay.com/photo/2017/09/16/16/09/sea-2755908__340.jpg");
        list.add("https://cd5n.pixabay.com/photo/2017/09/09/21/55/noodles-2733636__340.jpg");
        banner.setImages(list).setImageLoader(new BannerImageLoader()).start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
            }
        });
    }
}
