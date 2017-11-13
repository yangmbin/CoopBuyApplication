package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.Holder> {
    private List<MessageCenterResponse> data;
    private FootMarkPort port;

    public IncomeAdapter(List<MessageCenterResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public IncomeAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_income_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(IncomeAdapter.Holder holder, int position) {
        MessageCenterResponse srr = data.get(position);
        holder.mOrderNumber.setText("对账单号：" + srr.getTime());
        holder.mOrderTime.setText("出账时间：" + srr.getTime());
        if (data.size() == position + 1) {
            holder.mIncomeCall.setVisibility(View.VISIBLE);
        } else {
            holder.mIncomeCall.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mPrice;
        TextView mSaleType;
        TextView mCounts;
        TextView mOrderNumber;
        TextView mOrderTime;
        LinearLayout mIncomeCall;

        Holder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_name);
            mSaleType = itemView.findViewById(R.id.tv_sale_type);
            mOrderNumber = itemView.findViewById(R.id.tv_order_number);
            mCounts = itemView.findViewById(R.id.tv_order_counts);
            mPrice = itemView.findViewById(R.id.tv_order_price);
            mOrderTime = itemView.findViewById(R.id.tv_create_time);
            mIncomeCall = itemView.findViewById(R.id.ll_income_call);
        }
    }
}
