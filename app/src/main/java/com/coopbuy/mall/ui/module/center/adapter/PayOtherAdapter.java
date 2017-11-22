package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.PayOtherResponse;
import com.coopbuy.mall.ui.module.center.port.PayOtherPort;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class PayOtherAdapter extends RecyclerView.Adapter<PayOtherAdapter.Holder> {
    private List<PayOtherResponse.ItemsBean> data;
    private PayOtherPort port;

    public PayOtherAdapter(List<PayOtherResponse.ItemsBean> data, PayOtherPort port) {
        this.data = data;
        this.port = port;
    }

    public void addMore(List<PayOtherResponse.ItemsBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void refresh(List<PayOtherResponse.ItemsBean> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PayOtherAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payanther_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(PayOtherAdapter.Holder holder, int position) {
        PayOtherResponse.ItemsBean srr = data.get(position);
        holder.mName.setText(srr.getConsignerName());
        holder.mPrice.setText(srr.getApplyAmount() + "元");
        holder.mPhone.setText(srr.getConsignerTel());
        holder.mTime.setText(srr.getApplyTime());
        holder.mCall.setOnClickListener(new MyPort(position));
        holder.mRefuse.setOnClickListener(new MyPort(position));
        holder.mDetail.setOnClickListener(new MyPort(position));
        holder.mPayment.setOnClickListener(new MyPort(position));


    }

    class MyPort implements View.OnClickListener {
        private int postion;

        public MyPort(int postion) {
            this.postion = postion;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_call:
                    port.call(data.get(postion).getConsignerTel());
                    break;
                case R.id.tv_detail:
                    port.detail(postion);
                    break;
                case R.id.tv_refuse:
                    port.refuse();
                    break;
                case R.id.tv_payment:
                    port.payMent(postion);
                    break;
            }
        }
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
        RelativeLayout mDetail;
        TextView mPrice;
        TextView mTime;
        TextView mColseTime;
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
            mTime = itemView.findViewById(R.id.tv_time);
            mColseTime = itemView.findViewById(R.id.tv_order_close);
        }
    }
}
