package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeLayoutAdapter_8 extends BaseDelegateAdapter<Object> {

    private View.OnClickListener mListener;

    public HomeLayoutAdapter_8(Context ctx, List<Object> list, LayoutHelper mLayoutHelper, View.OnClickListener listener) {
        super(ctx, list, mLayoutHelper);
        this.mListener = listener;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_8_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, Object item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageResource(R.mipmap.ic_launcher);
        holder.getView(R.id.sdv_image).setOnClickListener(this.mListener);
    }
}
