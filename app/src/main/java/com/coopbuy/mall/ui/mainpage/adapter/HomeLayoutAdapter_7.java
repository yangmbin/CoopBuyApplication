package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.net.Uri;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeLayoutAdapter_7 extends BaseDelegateAdapter<HomePageDataResponse.FloorsBean.FloorItemsBean> {

    private List<HomePageDataResponse.FloorsBean.FloorItemsBean> floorItems;

    public HomeLayoutAdapter_7(Context ctx, List<HomePageDataResponse.FloorsBean.FloorItemsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        this.floorItems = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_7_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, HomePageDataResponse.FloorsBean.FloorItemsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + item.getObjectData().getImageUrl()));
    }
}
