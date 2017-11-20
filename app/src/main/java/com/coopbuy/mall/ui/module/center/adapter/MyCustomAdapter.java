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
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.api.reponse.MyBillReponse;
import com.coopbuy.mall.api.reponse.MyCustomReponse;
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
    private List<MyCustomReponse.ItemsBean> data;
    private FootMarkPort port;

    public MyCustomAdapter(List<MyCustomReponse.ItemsBean> data, FootMarkPort port) {
        this.data = data;
        this.port = port;
    }


    public void addMore(List<MyCustomReponse.ItemsBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void refresh(List<MyCustomReponse.ItemsBean> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public MyCustomAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mycustom_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomAdapter.Holder holder, final int position) {
        MyCustomReponse.ItemsBean srr = data.get(position);
        holder.mName.setText(srr.getCustomerName());
        holder.mAddress.setText(srr.getAddress());
        holder.mPhone.setText(srr.getPhone());
        holder.mFace.setImageURI(Constants.images[(new Random().nextInt(12) + 1)]);
        holder.mLlEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                port.openDetial(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mPhone;
        LinearLayout mLlEdit;
        TextView mAddress;
        SimpleDraweeView mFace;
        ImageView mEdit;

        Holder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_name);
            mPhone = itemView.findViewById(R.id.tv_phone);
            mAddress = itemView.findViewById(R.id.tv_address);
            mLlEdit = itemView.findViewById(R.id.ll_edit);
            mFace = itemView.findViewById(R.id.circleImageView);
            mEdit = itemView.findViewById(R.id.iv_edit);

        }
    }
}
