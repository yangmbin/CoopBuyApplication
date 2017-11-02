package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.api.reponse.TradeChannelResponse;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class PayListAdapter extends RecyclerView.Adapter<PayListAdapter.Holder> {
    private List<TradeChannelResponse> data;
    private FootMarkPort port;

    public PayListAdapter(List<TradeChannelResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }

    public void addData(List<TradeChannelResponse> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PayListAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itme_paylist_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(PayListAdapter.Holder holder, int position) {
        TradeChannelResponse srr = data.get(position);
        holder.logo.setImageURI(srr.getIcon());
        holder.enter.setOnClickListener(new MyClick(position));
        holder.mName.setText(srr.getName());
        if (srr.isSelect()) {
            holder.mSelect.setImageResource(R.mipmap.icon_address_checked);
        } else {
            holder.mSelect.setImageResource(R.mipmap.icon_address_unchecked);
        }
    }

    class MyClick implements View.OnClickListener {
        private int postion;

        public MyClick(int postion) {
            this.postion = postion;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.m_ll_paly:
                    port.openDetial(postion);
                    setSelect(postion);
                    break;
            }
        }
    }

    private void setSelect(int postion) {
        for (int i = 0; i < data.size(); i++) {
            if (i == postion) {
                data.get(i).setSelect(true);
            } else {
                data.get(i).setSelect(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView mName;
        LinearLayout enter;
        ImageView mSelect;
        SimpleDraweeView logo;

        Holder(View itemView) {
            super(itemView);
            enter = itemView.findViewById(R.id.m_ll_paly);
            mName = itemView.findViewById(R.id.pay_name);
            mSelect = itemView.findViewById(R.id.iv_paly);
            logo = itemView.findViewById(R.id.iv_pay_logo);
        }
    }
}
