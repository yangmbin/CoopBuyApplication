package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.api.reponse.SystemMegResponse;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 站长推荐适配器
 */
public class SystemMsgAdapter extends RecyclerView.Adapter<SystemMsgAdapter.Holder> {
    private List<SystemMegResponse.ItemsBean> data;
    private FootMarkPort port;

    public SystemMsgAdapter(List<SystemMegResponse.ItemsBean> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }

    public void addMore(List<SystemMegResponse.ItemsBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void refresh(List<SystemMegResponse.ItemsBean> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public SystemMsgAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_system_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SystemMsgAdapter.Holder holder, int position) {
        SystemMegResponse.ItemsBean srr = data.get(position);
        if (srr.getMessageType() == 3 || srr.getMessageType() == 4) {//订单消息 售后消息
            holder.mRlOrder.setVisibility(View.VISIBLE);
            holder.mLlTxt.setVisibility(View.GONE);
            holder.mOrderTitle.setText(srr.getTitle());
            if (srr.getItem() != null) {
                holder.mGoogsImags.setImageURI(srr.getItem().getProductImageUrl());
                holder.mOrderNumber.setText("订单号：" + srr.getItem().getOrderId());
                holder.mOrderName.setText(srr.getItem().getProductName());
            }
        } else {
            holder.mLlTxt.setVisibility(View.VISIBLE);
            holder.mRlOrder.setVisibility(View.GONE);
            if (srr.getMessageType() == 2) {//html 消息  注意详情是打开webview
                holder.logo.setVisibility(View.GONE);
            } else {//文本消息 没有封面图一
                holder.logo.setVisibility(View.VISIBLE);
                holder.logo.setImageURI(srr.getCoverImage());
            }
        }
        if (srr.isIsRead()) {
            holder.mOrderHint.setVisibility(View.GONE);
            holder.mTxtHint.setVisibility(View.GONE);
        } else {
            holder.mOrderHint.setVisibility(View.VISIBLE);
            holder.mTxtHint.setVisibility(View.VISIBLE);
        }
        holder.enter.setOnClickListener(new MyClick(position));
        holder.mRlOrder.setOnClickListener(new MyClick(position));
        holder.mTitle.setText(srr.getTitle());
        holder.msgDetail.setText(srr.getContent());
        holder.mTime.setText(srr.getSendTime());
    }

    class MyClick implements View.OnClickListener {
        private int postion;

        public MyClick(int postion) {
            this.postion = postion;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl_enter:
                case R.id.rl_order_type:
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
        TextView mTitle;
        TextView mTime;
        TextView mOrderTitle;
        TextView mOrderName;
        TextView mOrderNumber;
        TextView msgDetail;
        RelativeLayout mRlOrder;
        LinearLayout mLlTxt;
        View mTxtHint;
        View mOrderHint;
        RelativeLayout enter;
        SimpleDraweeView logo;
        SimpleDraweeView mGoogsImags;


        Holder(View itemView) {
            super(itemView);
            mGoogsImags = itemView.findViewById(R.id.goods_image);
            mRlOrder = itemView.findViewById(R.id.rl_order_type);
            mOrderTitle = itemView.findViewById(R.id.tv_title_two);
            mOrderName = itemView.findViewById(R.id.tv_name_two);
            mOrderNumber = itemView.findViewById(R.id.tv_order_number);
            mLlTxt = itemView.findViewById(R.id.ll_txt_type);
            mTxtHint = itemView.findViewById(R.id.v_red_hint_detail);
            mOrderHint = itemView.findViewById(R.id.v_red_hint);
            mTitle = itemView.findViewById(R.id.tv_title);
            mTime = itemView.findViewById(R.id.tv_time);
            msgDetail = itemView.findViewById(R.id.tv_detail);
            enter = itemView.findViewById(R.id.rl_enter);
            logo = itemView.findViewById(R.id.adFaceImage);
        }
    }
}
