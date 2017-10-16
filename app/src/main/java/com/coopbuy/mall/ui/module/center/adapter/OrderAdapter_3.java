package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.GetOrderListResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.StringUtils;

import java.util.List;

public class OrderAdapter_3 extends BaseDelegateAdapter<GetOrderListResponse.ItemsBean> {

    private View.OnClickListener mListener;

    public OrderAdapter_3(Context ctx, List<GetOrderListResponse.ItemsBean> list, LayoutHelper mLayoutHelper, View.OnClickListener mListener) {
        super(ctx, list, mLayoutHelper);
        this.mListener = mListener;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_list_type_3;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final GetOrderListResponse.ItemsBean item) {
        int totalQuantity = 0;
        for (int i = 0; i < item.getOrderItem().size(); i++)
            totalQuantity += item.getOrderItem().get(i).getQuantity();
        holder.getTextView(R.id.tv_desc).setText("共" + totalQuantity + "件商品 " + "合计：¥" + StringUtils.keepTwoDecimalPoint(item.getTotalAmount()) +
                "(含运费：" + StringUtils.keepTwoDecimalPoint(item.getFreightAmount()) + ")");
        holder.itemView.setOnClickListener(mListener);
    }
}
