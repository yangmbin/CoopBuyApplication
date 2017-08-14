package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.home.activity.ScanQrCodeActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.List;

public class HomeLayoutAdapter_9 extends BaseDelegateAdapter<Object> {

    private LinearLayout mLLTitleBar;

    public HomeLayoutAdapter_9(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
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
                IntentUtils.gotoActivity(mContext, ScanQrCodeActivity.class);
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
