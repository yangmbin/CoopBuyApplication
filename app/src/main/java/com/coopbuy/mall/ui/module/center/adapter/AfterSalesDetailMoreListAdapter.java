package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AfterSalesDetailResponse;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/19 11:39
 */
public class AfterSalesDetailMoreListAdapter extends BaseRecyclerAdapter<AfterSalesDetailResponse.ApplyNodesBean> {

    public AfterSalesDetailMoreListAdapter(Context ctx, List<AfterSalesDetailResponse.ApplyNodesBean> list) {
        super(ctx, list);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_after_sales_detail_more_list;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, AfterSalesDetailResponse.ApplyNodesBean item) {
        holder.getTextView(R.id.apply_text).setText(item.getText() + "：" + item.getTime());
    }
}
