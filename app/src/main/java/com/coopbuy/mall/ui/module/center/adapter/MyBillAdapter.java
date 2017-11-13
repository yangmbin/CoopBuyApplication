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
import com.coopbuy.mall.utils.Constants;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.Random;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class MyBillAdapter extends RecyclerView.Adapter<MyBillAdapter.Holder> {
    private List<MessageCenterResponse> data;
    private FootMarkPort port;

    public MyBillAdapter(List<MessageCenterResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public MyBillAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mybill_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MyBillAdapter.Holder holder, int position) {
        MessageCenterResponse srr = data.get(position);
        holder.mOrderNumber.setText("对账单号：" + srr.getTime());
        holder.mOrderTime.setText("出账时间：" + srr.getTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView mMonth;
        TextView mBillType;
        TextView mMoney;
        TextView mCounts;
        TextView mOrderNumber;
        TextView mOrderTime;


        Holder(View itemView) {
            super(itemView);
            mMonth = itemView.findViewById(R.id.tv_month_bill);
            mMoney = itemView.findViewById(R.id.tv_money);
            mOrderNumber = itemView.findViewById(R.id.tv_order_number);
            mBillType = itemView.findViewById(R.id.tv_bill_type);
            mCounts = itemView.findViewById(R.id.tv_conts);
            mOrderTime = itemView.findViewById(R.id.tv_order_times);
        }
    }
}
