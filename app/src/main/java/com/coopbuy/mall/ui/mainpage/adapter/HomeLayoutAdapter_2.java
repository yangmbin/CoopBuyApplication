package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.ui.module.home.activity.BannerDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeLayoutAdapter_2 extends BaseDelegateAdapter<HomePageDataResponse.FloorsBean.FloorItemsBean> {

    private List<HomePageDataResponse.FloorsBean.FloorItemsBean> floorItems;

    public HomeLayoutAdapter_2(Context ctx, List<HomePageDataResponse.FloorsBean.FloorItemsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        this.floorItems = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_2_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final HomePageDataResponse.FloorsBean.FloorItemsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + item.getImageUrl()));
        holder.getView(R.id.sdv_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getObjectId() != 1)
                    IntentUtils.gotoActivity(mContext, BannerDetailActivity.class, item.getObjectId() + "");
                else
                    ((MainActivity) mContext).setCurrentView(1);
            }
        });
    }
}
