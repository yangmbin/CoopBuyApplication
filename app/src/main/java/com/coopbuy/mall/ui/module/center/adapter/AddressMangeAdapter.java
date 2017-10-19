package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
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
        return R.layout.item_address_manage;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, AddressInfoResponse item) {
        holder.getTextView(R.id.tv_name).setText(item.getUserName());
        holder.getTextView(R.id.tv_phone).setText(item.getTel());
        holder.getTextView(R.id.tv_address).setText(item.getRegionName() + " " + item.getAddress());
        holder.getTextView(R.id.tv_station_name).setText(item.getStationName());
        holder.getTextView(R.id.tv_stationer_name).setText(item.getStationUserName());
    }

}
