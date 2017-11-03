package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AfterSalesResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class AfterSalesAdapter_1 extends BaseDelegateAdapter<AfterSalesResponse.ItemsBean> {

    private View.OnClickListener mListener;

    public AfterSalesAdapter_1(Context ctx, List<AfterSalesResponse.ItemsBean> list, LayoutHelper mLayoutHelper, View.OnClickListener listener) {
        super(ctx, list, mLayoutHelper);
        mListener = listener;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_1_order_after_sales;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final AfterSalesResponse.ItemsBean item) {
        holder.getTextView(R.id.tv_shop_name).setText(item.getShopName());

        // 点击监听
        holder.itemView.setOnClickListener(mListener);
    }
}
