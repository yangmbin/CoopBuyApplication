package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShopCartReponse;
import com.coopbuy.mall.ui.module.center.port.ShopCartPort;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by niu on 2017/10/24.
 */

public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.Holder> {
    private List<ShopCartReponse.ShopsBean.ProductsBean> data;
    private ShopCartPort port;

    public ShopCartAdapter(List<ShopCartReponse.ShopsBean.ProductsBean> data, ShopCartPort port) {
        this.data = data;
        this.port = port;
    }

    public void update(List<ShopCartReponse.ShopsBean.ProductsBean> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopcart_content_view, parent, false);
        return new ShopCartAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ShopCartReponse.ShopsBean.ProductsBean bean = data.get(position);
        holder.tv_name.setText(bean.getProductName());
        holder.tvVersion.setText(null != bean.getSpecifications() ? bean.getSpecifications() : "" + null != bean.getProperties() ? bean.getProperties() : "");
        holder.counts.setText(bean.getQuantity() + "");
        holder.salePrice.setText(bean.getProperties() + "");
        holder.iv_images.setImageURI(bean.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        TextView tv_name;

        TextView tvVersion;

        TextView oldPrice;

        TextView counts;

        TextView salePrice;

        SimpleDraweeView iv_images;

        Holder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_goods_name);
            tvVersion = (TextView) itemView.findViewById(R.id.tv_goods_version);
            counts = (TextView) itemView.findViewById(R.id.tv_goods_count);
            salePrice = (TextView) itemView.findViewById(R.id.tv_sale_price);
            oldPrice = (TextView) itemView.findViewById(R.id.tv_old_price);
            iv_images = (SimpleDraweeView) itemView.findViewById(R.id.adFaceImage);
        }
    }
}
