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
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.Holder> {
    private List<MessageCenterResponse> data;
    private FootMarkPort port;

    public MyCustomAdapter(List<MessageCenterResponse> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public MyCustomAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mycustom_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomAdapter.Holder holder, int position) {
        MessageCenterResponse srr = data.get(position);
        holder.mName.setText(srr.getName());
        holder.mAddress.setText(srr.getDetail());
        holder.mFace.setImageURI(Constants.images[(new Random().nextInt(12) + 1)]);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mPhone;
        TextView mAddress;
        SimpleDraweeView mFace;
        ImageView mEdit;

        Holder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_name);
            mPhone = itemView.findViewById(R.id.tv_phone);
            mAddress = itemView.findViewById(R.id.tv_address);
            mFace = itemView.findViewById(R.id.circleImageView);
            mEdit = itemView.findViewById(R.id.iv_edit);

        }
    }
}
