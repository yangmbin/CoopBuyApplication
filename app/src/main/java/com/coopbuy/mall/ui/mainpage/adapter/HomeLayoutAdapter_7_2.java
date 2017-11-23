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
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeLayoutAdapter_7_2 extends BaseDelegateAdapter<HomeFloorResponse.FloorItemsBean> {

    public HomeLayoutAdapter_7_2(Context ctx, List<HomeFloorResponse.FloorItemsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_7_2_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final HomeFloorResponse.FloorItemsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.image)).setImageURI(Uri.parse(item.getImageUrl()));
        holder.getTextView(R.id.goods_name).setText(item.getName());
        holder.getTextView(R.id.goods_desc).setText((TextUtils.isEmpty(item.getProperties()) ? "" : item.getProperties() + " ") +
                item.getSpecifications());
        holder.getTextView(R.id.price).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
        holder.getTextView(R.id.sale_count).setText("已售：" + item.getSalesNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.gotoActivityFromHome(mContext, item.getType(), item);
            }
        });
    }
}
