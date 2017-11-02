package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.net.Uri;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AfterSalesResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class AfterSalesAdapter_2 extends BaseDelegateAdapter<AfterSalesResponse.ItemsBean.ProductsBean> {

    public AfterSalesAdapter_2(Context ctx, List<AfterSalesResponse.ItemsBean.ProductsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_2_order_after_sales;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final AfterSalesResponse.ItemsBean.ProductsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Uri.parse(item.getProductImageUrl()));
        holder.getTextView(R.id.tv_goods_name).setText(item.getProductName());
        holder.getTextView(R.id.propertyDesc).setText((item.getProperties() == null ? "" : item.getProperties()) +
                (item.getSpecifications() == null ? "" : item.getSpecifications()));
        holder.getTextView(R.id.tv_quantity).setText("x" + item.getQuantity());
        holder.getTextView(R.id.refund_amount).setText("退款金额：¥" + StringUtils.keepTwoDecimalPoint(item.getUnitPrice()));
    }
}
