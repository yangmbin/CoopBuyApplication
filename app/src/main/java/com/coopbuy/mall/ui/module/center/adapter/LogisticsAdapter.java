package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.utils.Constants;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class LogisticsAdapter extends RecyclerView.Adapter<LogisticsAdapter.Holder> {
    private List<MessageCenterResponse> data;
    private FootMarkPort port;

    public LogisticsAdapter(List<MessageCenterResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public LogisticsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_logistics_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(LogisticsAdapter.Holder holder, int position) {
        MessageCenterResponse srr = data.get(position);
        holder.logo.setImageURI(Constants.images[position]);
        holder.enter.setOnClickListener(new MyClick(position));
        holder.mName.setText(srr.getName());
        holder.mGoodsName.setText(srr.getDetail());
        holder.mOrderNumber.setText("运单号：" + srr.getTime());
        holder.mTime.setText(srr.getTime());
    }

    class MyClick implements View.OnClickListener {
        private int postion;

        public MyClick(int postion) {
            this.postion = postion;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_enter:
                    port.openDetial(postion);
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
        TextView mTime;
        TextView mGoodsName;
        TextView mOrderNumber;
        LinearLayout enter;
        SimpleDraweeView logo;


        Holder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_logistics_name);
            mTime = itemView.findViewById(R.id.tv_time);
            mOrderNumber = itemView.findViewById(R.id.tv_order_number);
            mGoodsName = itemView.findViewById(R.id.tv_goods_name);
            enter = itemView.findViewById(R.id.ll_enter);
            logo = itemView.findViewById(R.id.adFaceImage);
        }
    }
}
