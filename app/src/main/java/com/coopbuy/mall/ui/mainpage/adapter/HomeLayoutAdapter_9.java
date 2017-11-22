package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.utils.IntentUtils;

import java.util.List;

public class HomeLayoutAdapter_9 extends BaseDelegateAdapter<Object> {

    public HomeLayoutAdapter_9(Context ctx, List<Object> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_9_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, Object item) {
        holder.getTextView(R.id.gc_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.gotoMainActivity(mContext, MainActivity.class, 1);
            }
        });
    }
}
