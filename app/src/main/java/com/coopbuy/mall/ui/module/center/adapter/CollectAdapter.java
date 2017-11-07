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
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.ui.module.center.port.CollectPort;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.utils.Constants;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class CollectAdapter extends RecyclerView.Adapter<CollectAdapter.Holder> {
    private List<CollectResponse> data;
    private CollectPort port;

    public CollectAdapter(List<CollectResponse> data, CollectPort port) {
        this.data = data;
        this.port = port;
    }


    @Override
    public CollectAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collect_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(CollectAdapter.Holder holder, int position) {
        CollectResponse srr = data.get(position);
        holder.logo.setImageURI(Constants.images[position]);
        holder.enter.setOnClickListener(new MyClick(position));
        holder.mLlGoodsSelect.setOnClickListener(new MyClick(position));
        holder.mGoodsName.setText(srr.getName());
        holder.mCount.setText("已售：" + srr.getSaleCounts());
        holder.mPrice.setText("$" + srr.getPrice());
        holder.mViersion.setText(srr.getVersion());
        if (srr.isSelect()) {
            holder.mGoodsSelect.setImageResource(R.mipmap.icon_address_checked);
        } else {
            holder.mGoodsSelect.setImageResource(R.mipmap.icon_address_unchecked);
        }
        if (srr.getCount() != 5) {
            holder.mRlFull.setVisibility(View.GONE);
        } else {
            if (srr.isSelect()) {
                holder.mRlFull.setVisibility(View.GONE);
            } else {
                holder.mRlFull.setVisibility(View.VISIBLE);
            }
        }
        if (data.size() - 1 == position) {
            holder.mLine.setVisibility(View.VISIBLE);
        } else {
            holder.mLine.setVisibility(View.GONE);
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
                case R.id.main:
                    port.openDetial(postion);
                    break;
                case R.id.ll_iamge_check:
                    setSelect(postion);
                    break;

            }
        }
    }

    private void setSelect(int postion) {
        boolean sele = !data.get(postion).isSelect();
        int count = data.get(postion).getCount();
        int countAvailable = data.get(postion).getCountAvailable();
        if (count == countAvailable && sele) {
            return;
        }
        if (sele) {
            ++count;
            if (count > countAvailable) {
                count = countAvailable;
            }
        } else {
            --count;
            if (count < 0) {
                count = 0;
            }
        }
        data.get(postion).setSelect(sele);
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setCount(count);
        }
        port.quantityClick(countAvailable - count);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        private RelativeLayout enter;
        private SimpleDraweeView logo;
        public TextView mPrice;
        /**
         * 商品名称
         */
        public TextView mGoodsName;
        /**
         * 商品数量
         */
        public TextView mCount;
        /**
         * 商品规格 颜色 尺寸
         */
        public TextView mViersion;
        /**
         * 加载图片动画
         */
        // public SpinKitView mSpinKitView;
        /**
         * 商品选中的
         */
        public ImageView mGoodsSelect;
        /**
         * 增加点击选中图片的区域
         */
        public LinearLayout mLlGoodsSelect;
        /**
         * 是否可选
         */
        public RelativeLayout mRlFull;
        public View mLine;

        Holder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.adFaceImage);
            mPrice = itemView.findViewById(R.id.tv_sale_price);
            mGoodsSelect = itemView.findViewById(R.id.iv_goods_select);
            logo = itemView.findViewById(R.id.adFaceImage);
            mGoodsName = itemView.findViewById(R.id.tv_goods_name);
            mCount = itemView.findViewById(R.id.tv_goods_counts);
            mViersion = itemView.findViewById(R.id.tv_goods_version);
            mLlGoodsSelect = itemView.findViewById(R.id.ll_iamge_check);
            enter = itemView.findViewById(R.id.main);
            mRlFull = itemView.findViewById(R.id.rl_full);
            mLine = itemView.findViewById(R.id.v_shopcart_line);
        }
    }
}
