package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.BeforeApplyRefundResponse;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ApplyRefundGoodsListAdapter extends BaseRecyclerAdapter<BeforeApplyRefundResponse.ProductsBean> {

    public ApplyRefundGoodsListAdapter(Context ctx, List<BeforeApplyRefundResponse.ProductsBean> list) {
        super(ctx, list);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_goods_apply_refund;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final BeforeApplyRefundResponse.ProductsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Uri.parse(item.getProductImageUrl()));
        holder.getTextView(R.id.tv_goods_name).setText(item.getProductName());
        holder.getTextView(R.id.propertyDesc).setText((TextUtils.isEmpty(item.getProperties()) ? "" : item.getProperties() + " ") +
                (TextUtils.isEmpty(item.getSpecifications()) ? "" : item.getSpecifications() + " "));
        holder.getTextView(R.id.price).setText("￥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
        holder.getTextView(R.id.tv_quantity).setText("x" + item.getQuantity());
    }
}
