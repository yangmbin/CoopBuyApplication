package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.StationRecommendResponse;
import com.coopbuy.mall.utils.Constants;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 站长推荐适配器
 */
public class StationRecAdapter extends RecyclerView.Adapter<StationRecAdapter.Holder> {
    private List<StationRecommendResponse> data;

    public StationRecAdapter() {
        data = new ArrayList<>();
    }

    public void addDatas(List<StationRecommendResponse> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public StationRecAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rec_station_recommend, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(StationRecAdapter.Holder holder, int position) {
        StationRecommendResponse srr = data.get(position);
        holder.iv_logo.setImageURI(Constants.images[position]);
        holder.tv_name.setText(srr.getName());
        holder.oldPrice.setText("￥" + srr.getOldPirce());
        holder.salePrice.setText("￥" + srr.getSalePrice());
        holder.saleCounts.setText("已售：" + srr.getSaleCount());
        holder.tvVersion.setText(srr.getVersion());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        TextView tv_name;

        TextView tvVersion;

        TextView oldPrice;

        TextView saleCounts;

        TextView onceBuy;

        TextView salePrice;

        SimpleDraweeView iv_logo;

        Holder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_goods_name);
            tvVersion = (TextView) itemView.findViewById(R.id.tv_goods_version);
            onceBuy = (TextView) itemView.findViewById(R.id.tv_once_buy);
            saleCounts = (TextView) itemView.findViewById(R.id.tv_sale_counts);
            salePrice = (TextView) itemView.findViewById(R.id.tv_sale_price);
            oldPrice = (TextView) itemView.findViewById(R.id.tv_old_price);
            iv_logo = (SimpleDraweeView) itemView.findViewById(R.id.adFaceImage);
        }
    }
}
