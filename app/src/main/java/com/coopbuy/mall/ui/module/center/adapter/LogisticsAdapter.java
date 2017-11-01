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
        if (srr.getType() == 0) {
            holder.logo.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509518176983&di=dc453196584a03ad8da581ac925750ad&imgtype=0&src=http%3A%2F%2Fwww.tusuku.com%2Fimg%2Fzhujiao-img%2F20150420214459_124.jpg");
        } else if (srr.getType() == 1) {
            holder.logo.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509518218513&di=7cdb51a7602b47fa88abe3f3ecac2a18&imgtype=0&src=http%3A%2F%2Fimg.tvmao.com%2Fthumb%2Fcharacter%2F149%2F630%2F260x346.jpg");
        } else if (srr.getType() == 2) {
            holder.logo.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509518249390&di=5a0fdcefafac0496a7c9ff85b8a02569&imgtype=0&src=http%3A%2F%2Fnews.cnhubei.com%2Fxw%2Fyl%2F201405%2FW020140525547566409638.jpg");
        } else {
            holder.logo.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510113013&di=5c1d5afeb8e78cf20825e9ae497daa5d&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D08163430b6315c60579863ace5d8a166%2F35a85edf8db1cb13a1bca436d754564e92584b3a.jpg");
        }
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
