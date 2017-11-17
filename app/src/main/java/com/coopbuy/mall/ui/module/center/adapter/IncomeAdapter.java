package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.InComeReponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.Holder> {
    private List<InComeReponse.ItemsBean> data;
    private FootMarkPort port;
    private Context context;

    public IncomeAdapter(Context context, List<InComeReponse.ItemsBean> data, FootMarkPort port) {
        this.context = context;
        this.data = data;
        this.port = port;
    }

    public void addMore(List<InComeReponse.ItemsBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void refresh(List<InComeReponse.ItemsBean> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public IncomeAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_income_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(IncomeAdapter.Holder holder, int position) {
        InComeReponse.ItemsBean srr = data.get(position);
        holder.mOrderNumber.setText("对账单号：" + srr.getOrderId());
        holder.mOrderTime.setText("出账时间：" + srr.getOrderTime());
        holder.mName.setText(srr.getUserName());
        holder.mPrice.setText("合计价格：￥" + srr.getOrderAmount() + "含运费￥" + srr.getFreightAmount());
        holder.mSaleType.setText(srr.getOrderStatus());
        holder.mCounts.setText("商品数量：" + srr.getProductCount() + "");
        if (data.size() == position + 1) {
            holder.mIncomeCall.setVisibility(View.VISIBLE);
        } else {
            holder.mIncomeCall.setVisibility(View.GONE);
        }
        if (srr.getCommissionType() == 1) {
            holder.mIncome.setText("+" + srr.getCommissionAmount());
            holder.mIncome.setTextColor(context.getResources().getColor(R.color.theme_text_title_orange));
        } else {
            holder.mIncome.setText("-" + srr.getCommissionAmount());
            holder.mIncome.setTextColor(context.getResources().getColor(R.color.theme_text_lab_black));
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
        TextView mIncome;
        LinearLayout mIncomeCall;

        Holder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_name);
            mSaleType = itemView.findViewById(R.id.tv_sale_type);
            mOrderNumber = itemView.findViewById(R.id.tv_order_number);
            mCounts = itemView.findViewById(R.id.tv_order_counts);
            mPrice = itemView.findViewById(R.id.tv_order_price);
            mOrderTime = itemView.findViewById(R.id.tv_create_time);
            mIncome = itemView.findViewById(R.id.tv_income);
            mIncomeCall = itemView.findViewById(R.id.ll_income_call);
        }
    }
}
