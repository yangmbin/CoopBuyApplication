package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.net.Uri;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.login.HomePageDataResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeLayoutAdapter_5 extends BaseDelegateAdapter<HomePageDataResponse.FloorsBean.FloorItemsBean> {

    private List<HomePageDataResponse.FloorsBean.FloorItemsBean> floorItems;

    public HomeLayoutAdapter_5(Context ctx, List<HomePageDataResponse.FloorsBean.FloorItemsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
        this.floorItems = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_5_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, HomePageDataResponse.FloorsBean.FloorItemsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + item.getObjectData().getImageUrl()));
        holder.getTextView(R.id.tv_name).setText(item.getObjectData().getGoodsName());
        holder.getTextView(R.id.tv_price).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getObjectData().getSellingPrice()));
    }
}
