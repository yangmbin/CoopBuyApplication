package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.ui.module.center.port.CustomOrderPort;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class CustomOrderAdapter extends RecyclerView.Adapter<CustomOrderAdapter.Holder> {
    private List<MessageCenterResponse> data;
    private CustomOrderPort port;

    public CustomOrderAdapter(List<MessageCenterResponse> data, CustomOrderPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public CustomOrderAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_custom_order, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(CustomOrderAdapter.Holder holder, int position) {
        MessageCenterResponse srr = data.get(position);
        holder.mName.setText(srr.getName());
        holder.mOrderTime.setText("出账时间：" + srr.getTime());
        if (srr.getType() == 2) {
            holder.mWaitPay.setVisibility(View.VISIBLE);
        } else {
            holder.mWaitPay.setVisibility(View.GONE);
        }
        holder.mDetail.setOnClickListener(new MyPort(position));
    }

    class MyPort implements View.OnClickListener {
        private int position;

        public MyPort(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_logistics:
                    port.logistics(position);
                    break;
                case R.id.btn_detail:
                    port.openDetial(position);
                    break;
                case R.id.btn_call_custom:
                    port.call(position);
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
        TextView mAllPrice;
        TextView mOrderStatus;
        TextView mCounts;
        TextView mOrderTime;
        TextView mCloseTime;
        LinearLayout mWaitPay;
        Button mLogistics;
        Button mDetail;
        Button mCall;

        Holder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_custom_name);
            mOrderStatus = itemView.findViewById(R.id.tv_order_status);
            mPhone = itemView.findViewById(R.id.tv_phone);
            mCounts = itemView.findViewById(R.id.tv_goods_counts);
            mAllPrice = itemView.findViewById(R.id.tv_all_price);
            mOrderTime = itemView.findViewById(R.id.tv_create_time);
            mLogistics = itemView.findViewById(R.id.btn_logistics);
            mDetail = itemView.findViewById(R.id.btn_detail);
            mCall = itemView.findViewById(R.id.btn_call_custom);
            mCloseTime = itemView.findViewById(R.id.tv_close_time);
            mWaitPay = itemView.findViewById(R.id.ll_wait_pay);
        }
    }
}
