package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.InComeReponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.api.reponse.MyBillReponse;
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
    private List<MyBillReponse.ItemsBean> data;
    private FootMarkPort port;
    private Context context;

    public MyBillAdapter(Context context, List<MyBillReponse.ItemsBean> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
        this.context = context;
    }

    public void addMore(List<MyBillReponse.ItemsBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void refresh(List<MyBillReponse.ItemsBean> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public MyBillAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mybill_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MyBillAdapter.Holder holder, int position) {
        MyBillReponse.ItemsBean srr = data.get(position);
        holder.mOrderNumber.setText("对账单号：" + "差的");
        holder.mOrderTime.setText("出账时间：" + srr.getBookTime());
        holder.mMoney.setText(srr.getBookAmount() + "元");
        holder.mCounts.setText(srr.getTotalOrderCount() + "笔");
        holder.mMonth.setText(srr.getBookTime());
        getState(srr.getStatus(), holder.mBillType);
    }

    private void getState(int status, TextView holder) {
        String msg = "";
        int color = context.getResources().getColor(R.color.auxiliary_text_blue_gray);
        switch (status) {
            case 0:
                msg = "待审核";
                color = context.getResources().getColor(R.color.theme_text_title_orange);
                break;
            case 1:
                msg = "已审核";
                break;
            case 2:
                msg = "已发放";
                break;
            case 3:
                msg = "已作废";
                break;
        }
        holder.setText(msg);
        holder.setTextColor(color);
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
