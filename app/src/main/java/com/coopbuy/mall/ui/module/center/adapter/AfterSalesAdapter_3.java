package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AfterSalesResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class AfterSalesAdapter_3 extends BaseDelegateAdapter<AfterSalesResponse.ItemsBean> {

    public AfterSalesAdapter_3(Context ctx, List<AfterSalesResponse.ItemsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_3_order_after_sales;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final AfterSalesResponse.ItemsBean item) {
        holder.getTextView(R.id.status_name).setText(item.getStatusName());
        if (item.isNeedReturnGoods())
            holder.getImageView(R.id.refund_type_image).setImageResource(R.mipmap.icon_refund_huo);
        else
            holder.getImageView(R.id.refund_type_image).setImageResource(R.mipmap.icon_refund_kuan);
    }
}
