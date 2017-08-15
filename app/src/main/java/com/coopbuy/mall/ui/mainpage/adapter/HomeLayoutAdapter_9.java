package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.fragment.OneFragment;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.List;

public class HomeLayoutAdapter_9 extends BaseDelegateAdapter<Object> {

    private LinearLayout mLLTitleBar;
    private OneFragment mFragment;

    public HomeLayoutAdapter_9(Context ctx, List<Object> list, LayoutHelper mLayoutHelper, OneFragment mFragment) {
        super(ctx, list, mLayoutHelper);
        this.mFragment = mFragment;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_9_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, Object item) {
        mLLTitleBar = (LinearLayout) holder.getView(R.id.ll_home_titlebar);
        holder.getView(R.id.ll_item_9_home).setOnClickListener(null);
        holder.getView(R.id.ll_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.toastShort("中");
            }
        });
        holder.getView(R.id.fl_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragment.requestPermission();
            }
        });
        holder.getView(R.id.fl_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.toastShort("右");
            }
        });
    }

    public LinearLayout getTitleBarLayout() {
        return mLLTitleBar;
    }
}
