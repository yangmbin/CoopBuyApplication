package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.GetOrderListResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.ScreenUtils;
import com.coopbuy.mall.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class OrderAdapter extends BaseDelegateAdapter<GetOrderListResponse.ItemsBean> {

    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    private RecyclerView mRvGoods;

    public OrderAdapter(Context ctx, List<GetOrderListResponse.ItemsBean> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_order_list;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final GetOrderListResponse.ItemsBean item) {
        holder.getTextView(R.id.tv_shop_name).setText(item.getShopName());
        holder.getTextView(R.id.tv_status).setText(item.getStatusName());
        int totalQuantity = 0;
        for (int i = 0; i < item.getOrderItem().size(); i++)
            totalQuantity += item.getOrderItem().get(i).getQuantity();
        holder.getTextView(R.id.tv_desc).setText("共" + totalQuantity + "件商品 " + "合计：¥" + StringUtils.keepTwoDecimalPoint(item.getTotalAmount()) +
                "(含运费：" + StringUtils.keepTwoDecimalPoint(item.getFreightAmount()) + ")");

        // 订单列表单条嵌套商品列表
        mAdapters.clear();
        mRvGoods = (RecyclerView) holder.getView(R.id.rv_goods);
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        manager.setAutoMeasureEnabled(true);
        mRvGoods.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRvGoods.setAdapter(mDelegateAdapter);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRvGoods.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        LinearLayoutHelper linearListHelper = new LinearLayoutHelper();
        linearListHelper.setDividerHeight(ScreenUtils.dp2px(mContext, 2));
        mAdapters.add(new OrderGoodsAdapter(mContext, item.getOrderItem(), linearListHelper));
        mDelegateAdapter.setAdapters(mAdapters);
    }
}
