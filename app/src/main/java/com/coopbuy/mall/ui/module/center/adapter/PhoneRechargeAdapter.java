package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.PhoneRechargeListReponse;
import com.coopbuy.mall.api.reponse.TradeChannelResponse;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class PhoneRechargeAdapter extends RecyclerView.Adapter<PhoneRechargeAdapter.Holder> {
    private List<PhoneRechargeListReponse> data;
    private FootMarkPort port;
    private Context context;

    public PhoneRechargeAdapter(Context context, List<PhoneRechargeListReponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
        this.context = context;
    }

    public void addData(List<PhoneRechargeListReponse> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public PhoneRechargeAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_phone_charge, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(PhoneRechargeAdapter.Holder holder, int position) {
        PhoneRechargeListReponse srr = data.get(position);
        holder.mMark.setText(srr.getFaceValue() + "元");
        holder.llPhone.setOnClickListener(new MyClick(position));
        holder.mSalePrice.setText("售价:" + srr.getSalePrice() + "元");
        if (srr.isSelect()) {
            holder.llPhone.setBackgroundResource(R.drawable.bg_round_corner_orange_phone_charge);
            holder.mMark.setTextColor(context.getResources().getColor(R.color.orange));
            holder.mSalePrice.setTextColor(context.getResources().getColor(R.color.orange));
        } else {
            holder.mMark.setTextColor(context.getResources().getColor(R.color.auxiliary_text_blue_gray));
            holder.mSalePrice.setTextColor(context.getResources().getColor(R.color.auxiliary_text_blue_gray));
            holder.llPhone.setBackgroundResource(R.drawable.bg_round_corner_gray_phone_charge);
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
                case R.id.ll_phone_charge:
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
        TextView mMark;
        LinearLayout llPhone;
        TextView mSalePrice;


        Holder(View itemView) {
            super(itemView);
            mMark = itemView.findViewById(R.id.tv_mark_price);
            llPhone = itemView.findViewById(R.id.ll_phone_charge);
            mSalePrice = itemView.findViewById(R.id.tv_sale_price);
        }
    }
}
