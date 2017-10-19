package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.center.activity.ApplyRefundActivity;
import com.coopbuy.mall.utils.IntentUtils;

import java.util.List;

public class AfterSalesAdapter extends BaseDelegateAdapter<Object> {

    public AfterSalesAdapter(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_after_sales;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.gotoActivity(mContext, ApplyRefundActivity.class);
            }
        });
    }
}
