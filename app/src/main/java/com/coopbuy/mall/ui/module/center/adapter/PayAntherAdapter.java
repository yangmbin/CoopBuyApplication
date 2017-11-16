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
public class PayAntherAdapter extends RecyclerView.Adapter<PayAntherAdapter.Holder> {
    private List<MessageCenterResponse> data;
    private FootMarkPort port;

    public PayAntherAdapter(List<MessageCenterResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public PayAntherAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payanther_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(PayAntherAdapter.Holder holder, int position) {
        MessageCenterResponse srr = data.get(position);
        holder.mName.setText(srr.getName());
        holder.mPrice.setText(srr.getType());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mPhone;
        TextView mRefuse;
        TextView mPayment;
        TextView mDetail;
        TextView mPrice;
        LinearLayout mCall;

        Holder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_name);
            mPhone = itemView.findViewById(R.id.tv_phone);
            mRefuse = itemView.findViewById(R.id.tv_refuse);
            mPayment = itemView.findViewById(R.id.tv_payment);
            mDetail = itemView.findViewById(R.id.tv_detail);
            mPrice = itemView.findViewById(R.id.tv_price_counts);
            mCall = itemView.findViewById(R.id.ll_call);
        }
    }
}
