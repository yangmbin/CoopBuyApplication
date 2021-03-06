package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MesCenterResponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 站长推荐适配器
 */
public class MessageCenterAdapter extends RecyclerView.Adapter<MessageCenterAdapter.Holder> {
    private List<MesCenterResponse> data;
    private FootMarkPort port;

    public MessageCenterAdapter(List<MesCenterResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public MessageCenterAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mesg_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MessageCenterAdapter.Holder holder, int position) {
        MesCenterResponse srr = data.get(position);
        if (srr.getId() == 3) {
            holder.logo.setImageResource(R.mipmap.icon_msg_logisics);
        } else if (srr.getId() == 2) {
            holder.logo.setImageResource(R.mipmap.icon_msg_message);
        } else {
            holder.logo.setImageResource(R.mipmap.icon_msg_system);
        }
        holder.mName.setText(srr.getName());
        holder.msgDetail.setText(srr.getNewMessage());
        holder.mTime.setText(srr.getLastMessageTime());
        if (srr.getUnreadMessageCount() > 0) {
            holder.mCounts.setText(srr.getUnreadMessageCount() + "");
            holder.mCounts.setVisibility(View.VISIBLE);
        } else {
            holder.mCounts.setVisibility(View.GONE);
        }
        holder.mEnter.setOnClickListener(new MyClick(position));
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
        LinearLayout mEnter;
        TextView mTime;
        TextView msgDetail;
        ImageView logo;
        TextView mCounts;

        Holder(View itemView) {
            super(itemView);
            mEnter = (LinearLayout) itemView.findViewById(R.id.ll_enter);
            mName = (TextView) itemView.findViewById(R.id.tv_logistics);
            mCounts = (TextView) itemView.findViewById(R.id.tv_counts);
            mTime = (TextView) itemView.findViewById(R.id.tv_time);
            msgDetail = (TextView) itemView.findViewById(R.id.tv_detial);
            logo = (ImageView) itemView.findViewById(R.id.iv_logo);

        }
    }
}
