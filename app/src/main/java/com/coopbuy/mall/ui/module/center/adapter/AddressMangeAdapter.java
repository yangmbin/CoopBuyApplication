package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/18 0018 9:39
 * @content
 */
public class AddressMangeAdapter extends BaseDelegateAdapter<AddressInfoResponse> {
    public AddressMangeAdapter(Context ctx, List<AddressInfoResponse> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return 0;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, AddressInfoResponse item) {

    }
}
