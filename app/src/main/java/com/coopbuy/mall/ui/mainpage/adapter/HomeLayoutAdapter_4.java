package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.imageloader.BannerImageLoader;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.List;

public class HomeLayoutAdapter_4 extends BaseDelegateAdapter<HomePageDataResponse.FloorsBean> {

    private List<HomePageDataResponse.FloorsBean> floors;

    public HomeLayoutAdapter_4(Context ctx, List<HomePageDataResponse.FloorsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        this.floors = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_4_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, HomePageDataResponse.FloorsBean item) {
        if (!TextUtils.isEmpty(item.getTitleImage())) {
            holder.getView(R.id.sdv_title).setVisibility(View.VISIBLE);
            ((SimpleDraweeView) holder.getView(R.id.sdv_title)).setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL) + item.getTitleImage());
        } else {
            holder.getView(R.id.sdv_title).setVisibility(View.GONE);
        }
        Banner banner = (Banner) holder.getView(R.id.banner);
        banner.setImages(item.getFloorItems()).setImageLoader(new BannerImageLoader()).start();
    }
}
