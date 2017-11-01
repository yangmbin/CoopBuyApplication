package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 站长推荐适配器
 */
public class SystemMsgAdapter extends RecyclerView.Adapter<SystemMsgAdapter.Holder> {
    private List<MessageCenterResponse> data;
    private FootMarkPort port;

    public SystemMsgAdapter(List<MessageCenterResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public SystemMsgAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_system_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SystemMsgAdapter.Holder holder, int position) {
        MessageCenterResponse srr = data.get(position);
        if (srr.getType() == 0) {
            holder.logo.setImageURI("http://upload.cankaoxiaoxi.com/2017/0712/1499849318278.jpg");
        } else if (srr.getType() == 1) {
            holder.logo.setVisibility(View.GONE);
        } else {
            holder.logo.setImageURI("http://upload.cankaoxiaoxi.com/2017/0712/1499849319452.jpg");
        }
        holder.enter.setOnClickListener(new MyClick(position));
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
                case R.id.rl_enter:
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
        RelativeLayout enter;
        SimpleDraweeView logo;


        Holder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_title);
            mTime = itemView.findViewById(R.id.tv_time);
            msgDetail = itemView.findViewById(R.id.tv_detail);
            enter = itemView.findViewById(R.id.rl_enter);
            logo = itemView.findViewById(R.id.adFaceImage);
        }
    }
}
