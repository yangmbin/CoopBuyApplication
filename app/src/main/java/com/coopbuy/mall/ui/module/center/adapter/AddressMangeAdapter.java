package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.center.port.AddressPort;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/18 0018 9:39
 * @content
 */
public class AddressMangeAdapter extends BaseDelegateAdapter<AddressInfoResponse> {
    private AddressPort port;
    private TextView setDefault;
    private TextView mEdit;
    private TextView mDelete;
    private LinearLayout mIshasbind;
    private LinearLayout mSetShopAddress;
    private List<AddressInfoResponse> list;

    public AddressMangeAdapter(Context ctx, List<AddressInfoResponse> list, LayoutHelper mLayoutHelper, AddressPort port) {
        super(ctx, list, mLayoutHelper);
        this.port = port;
        this.list = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_address_manage;
    }

    public void flesh(List<AddressInfoResponse> list) {
        if (!this.list.isEmpty()) {
            this.list.clear();
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, AddressInfoResponse item) {
        holder.getTextView(R.id.tv_name).setText(item.getUserName());
        holder.getTextView(R.id.tv_phone).setText(item.getTel());
        holder.getTextView(R.id.tv_address).setText(item.getRegionName() + " " + item.getAddress());
        holder.getTextView(R.id.tv_station_name).setText(item.getStationName());
        holder.getTextView(R.id.tv_stationer_name).setText(item.getStationUserName());
        setDefault = holder.getTextView(R.id.tv_setdefault);
        mIshasbind = (LinearLayout) holder.getView(R.id.ll_ishasbind);
        mSetShopAddress = (LinearLayout) holder.getView(R.id.ll_address);
        mEdit = holder.getTextView(R.id.tv_edit);
        mDelete = holder.getTextView(R.id.tv_delete);
        mEdit.setOnClickListener(new MyListenter(item));
        setDefault.setOnClickListener(new MyListenter(item));
        mDelete.setOnClickListener(new MyListenter(item));
        mSetShopAddress.setOnClickListener(new MyListenter(item));
        if (item.isIsDefault()) {
            setDefault.setBackgroundResource(R.mipmap.icon_address_checked);
        } else {
            setDefault.setBackgroundResource(R.mipmap.icon_address_unchecked);
        }
        //控制没有服务站的显示
        if (item.isHasBindStation()) {
            mIshasbind.setVisibility(View.VISIBLE);
        } else {
            mIshasbind.setVisibility(View.GONE);
        }
    }

    public class MyListenter implements View.OnClickListener {
        private AddressInfoResponse bean;

        public MyListenter(AddressInfoResponse bean) {
            this.bean = bean;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_edit:
                    port.editAddress(bean);
                    break;
                case R.id.tv_delete:
                    port.delete(bean);
                    break;
                case R.id.ll_address:
                    port.setReceivedAddress(bean);
                    break;
                case R.id.tv_setdefault:
                    port.setDefault(bean);
                    break;
            }
        }
    }
}
