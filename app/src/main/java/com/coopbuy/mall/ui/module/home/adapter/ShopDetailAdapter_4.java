package com.coopbuy.mall.ui.module.home.adapter;


import android.content.Context;
import android.net.Uri;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.SearchResultResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ShopDetailAdapter_4 extends BaseDelegateAdapter<SearchResultResponse.ResultBean.ItemsBean> {

    public ShopDetailAdapter_4(Context ctx, List<SearchResultResponse.ResultBean.ItemsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_4_shop_detail;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final SearchResultResponse.ResultBean.ItemsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.image)).setImageURI(Uri.parse(item.getImageUrl()));
        holder.getTextView(R.id.goods_name).setText(item.getProductName());
        holder.getTextView(R.id.sale_price).setText("¥" + StringUtils.keepTwoDecimalPoint(item.getSellingPrice()));
        holder.getTextView(R.id.sale_count).setText("已售：" + item.getSellingNumber());
    }
}
