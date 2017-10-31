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
import com.coopbuy.mall.api.reponse.StationRecommendResponse;
import com.coopbuy.mall.ui.module.center.activity.FootMarkActivity;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 站长推荐适配器
 */
public class FootMarkAdapter extends RecyclerView.Adapter<FootMarkAdapter.Holder> {
    private List<FootMarkResponse.ItemsBean.ProductsBean> data;
    private FootMarkPort port;

    public FootMarkAdapter(List<FootMarkResponse.ItemsBean.ProductsBean> data, FootMarkPort port) {
        this.data = data;  this.port = port;
    }

    public void addData(List<FootMarkResponse.ItemsBean.ProductsBean> data) {
        notifyData(data);
    }

    public void flesh(List<FootMarkResponse.ItemsBean.ProductsBean> data) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        notifyData(data);
    }

    public void notifyData(List<FootMarkResponse.ItemsBean.ProductsBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public FootMarkAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footmark_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(FootMarkAdapter.Holder holder, int position) {
        FootMarkResponse.ItemsBean.ProductsBean srr = data.get(position);
        holder.iv_logo.setImageURI(srr.getImageUrl());
        holder.tv_name.setText(srr.getProductName());
        holder.salePrice.setText("￥" + srr.getSalesPrice());
        holder.saleCounts.setVisibility(View.GONE);
        holder.tvVersion.setVisibility(View.GONE);
        holder.mImageSelect.setOnClickListener(new MyClick(position));
        holder.mDetail.setOnClickListener(new MyClick(position));
        if (FootMarkActivity.isEdit) {
            holder.mImageSelect.setVisibility(View.VISIBLE);
            if (srr.getSelect()) {
                holder.select.setBackgroundResource(R.mipmap.icon_address_checked);
            } else {
                holder.select.setBackgroundResource(R.mipmap.icon_address_unchecked);
            }
        } else {
            holder.mImageSelect.setVisibility(View.GONE);
        }
    }

    class MyClick implements View.OnClickListener {
        private int postion;

        public MyClick(int postion) {
            this.postion = postion;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_iamge_check:
                    setSelect(postion);
                    break;
                case R.id.ll_footmark:
                    port.openDetial(postion);
                    break;
            }
        }
    }

    private void setSelect(int postion) {
        for (int i = 0; i < data.size(); i++) {
            if (postion == i) {
                boolean isSelect = data.get(i).getSelect();
                data.get(i).setSelect(!isSelect);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        TextView tv_name;

        TextView tvVersion;

        TextView saleCounts;
        LinearLayout mImageSelect;
        LinearLayout mDetail;

        TextView select;

        TextView salePrice;

        SimpleDraweeView iv_logo;

        Holder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_goods_name);
            tvVersion = (TextView) itemView.findViewById(R.id.tv_goods_version);
            select = (TextView) itemView.findViewById(R.id.tv_goods_select);
            mImageSelect = (LinearLayout) itemView.findViewById(R.id.ll_iamge_check);
            mDetail = (LinearLayout) itemView.findViewById(R.id.ll_footmark);
            saleCounts = (TextView) itemView.findViewById(R.id.tv_goods_counts);
            salePrice = (TextView) itemView.findViewById(R.id.tv_sale_price);
            iv_logo = (SimpleDraweeView) itemView.findViewById(R.id.adFaceImage);
        }
    }
}
