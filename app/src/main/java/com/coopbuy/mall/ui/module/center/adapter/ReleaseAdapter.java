package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.ui.module.center.port.CollectPort;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.Random;

/**
 * @author csn
 * @date 2017/10/13 0013 10:51
 * @content 物流
 */
public class ReleaseAdapter extends RecyclerView.Adapter<ReleaseAdapter.Holder> {
    private List<CollectResponse.ItemsBean> data;
    private CollectPort port;
    private Context context;

    public ReleaseAdapter(Context context, List<CollectResponse.ItemsBean> data, CollectPort port) {
        this.data = data;
        this.context = context;
        this.port = port;
    }


    @Override
    public ReleaseAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collect_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(ReleaseAdapter.Holder holder, final int position) {
        CollectResponse.ItemsBean srr = data.get(position);
        holder.logo.setImageURI(srr.getProductImageUrl());
        holder.enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                port.openDetial(position);
            }
        });

        holder.mGoodsName.setText(srr.getProductName());
        holder.mCount.setText("已售：" + srr.getSales());
        holder.mPrice.setText("￥" + srr.getUnitPrice());
        holder.mViersion.setText(srr.getProperties());
        holder.mRlFull.setVisibility(View.GONE);
        holder.mLlGoodsSelect.setVisibility(View.GONE);
        if (data.size() - 1 == position) {
            holder.mLine.setVisibility(View.VISIBLE);
        } else {
            holder.mLine.setVisibility(View.GONE);
        }
    }


    /**
     * 取消订单
     */
    private void moveRelase(final int postion) {
        DialogUtils.showTwoKeyDialog(context, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                port.quantityClick(postion);
                data.remove(postion);
                notifyDataSetChanged();
            }
        }, "确定要取消本商品推荐？", "取消", "确定");
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
