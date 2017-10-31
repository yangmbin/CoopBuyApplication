package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.FootMarkResponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.ui.module.center.activity.FootMarkActivity;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 站长推荐适配器
 */
public class MessageCenterAdapter extends RecyclerView.Adapter<MessageCenterAdapter.Holder> {
    private List<MessageCenterResponse> data;
    private FootMarkPort port;

    public MessageCenterAdapter(List<MessageCenterResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public MessageCenterAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itme_mesg_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MessageCenterAdapter.Holder holder, int position) {
        MessageCenterResponse srr = data.get(position);
        if (srr.getType() == 0) {
            holder.logo.setImageResource(R.mipmap.icon_msg_logisics);
        } else if (srr.getType() == 0) {
            holder.logo.setImageResource(R.mipmap.icon_msg_message);
        } else {
            holder.logo.setImageResource(R.mipmap.icon_msg_system);
        }
        holder.mName.setText(srr.getName());
        holder.msgDetail.setText(srr.getDetail());
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
                case R.id.ll_footmark:
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
        TextView msgDetail;
        ImageView logo;


        Holder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.tv_logistics);
            mTime = (TextView) itemView.findViewById(R.id.tv_time);
            msgDetail = (TextView) itemView.findViewById(R.id.tv_detial);
            logo = (ImageView) itemView.findViewById(R.id.iv_logo);

        }
    }
}
