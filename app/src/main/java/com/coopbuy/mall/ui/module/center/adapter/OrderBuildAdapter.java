package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderBuildResponse;
import com.facebook.drawee.view.SimpleDraweeView;


import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */

/**
 * @USER csn
 * @date 2017/5/9 0009 17:14
 * @content
 */
public class OrderBuildAdapter extends RecyclerView.Adapter<OrderBuildAdapter.MyHolder> {
    private Context context;
    private List<OrderBuildResponse.ShopsBean.ProductsBean> data;
    private RecyclerView mRecyclerView;
    private View VIEW_FOOTER;
    private View VIEW_HEADER;
    DecimalFormat df = new DecimalFormat("0.00");
    //Type
    private int TYPE_NORMAL = 1000;
    private int TYPE_HEADER = 1001;
    private int TYPE_FOOTER = 1002;

    public OrderBuildAdapter(Context context, List<OrderBuildResponse.ShopsBean.ProductsBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public OrderBuildAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            return new MyHolder(VIEW_FOOTER);
        } else if (viewType == TYPE_HEADER) {
            return new MyHolder(VIEW_HEADER);
        } else {
            return new MyHolder(getLayout(R.layout.item_shop_order_confirm));
        }
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        if (!isHeaderView(position) && !isFooterView(position)) {
            // holder.mEdit.setVisibility(View.GONE);
            if (haveHeaderView()) position--;

            if (position > 0) { //让头部显示不显示
                //这里是通过后面一个店铺和前面一个店铺的id进行比较 相同不是同一个商铺的商品 归为一类
                if (data.get(position).getShopId() == (data.get(position - 1).getShopId())) { //如果服务器的商铺的商品不是 一起 估计有错  对的我的猜测
                    holder.llShopCartHeader.setVisibility(View.GONE);
                    //holder.vLine.setVisibility(View.GONE);
                } else {
                    //  holder.vLine.setVisibility(View.VISIBLE);
                    holder.llShopCartHeader.setVisibility(View.VISIBLE);//这是一件商品时
                }
            } else {
                //  holder.vLine.setVisibility(View.VISIBLE);
                holder.llShopCartHeader.setVisibility(View.VISIBLE);
            }
            if (data.get(position).getIsend() == 1) {//是不是第一个或者最后一个
                holder.llConfrimFoot.setVisibility(View.VISIBLE);
                getShopGoodsCount(position, holder);
            } else {
                holder.llConfrimFoot.setVisibility(View.GONE);
            }
            //单个商品是否删除显示界面 点击编辑时

            holder.mViersion.setText(null != data.get(position).getSpecifications() ? data.get(position).getSpecifications() : "" + null != data.get(position).getProperties() ? data.get(position).getProperties() : "");
            holder.mGoodsName.setText(data.get(position).getProductName());
            holder.mShopName.setText(data.get(position).getShopName() + "");
            holder.mPrice.setText("￥" + df.format(data.get(position).getUnitPrice()));
            holder.mCount.setText("x" + data.get(position).getQuantity());

            if (data.get(position).getFreight() == 0) {
                holder.tvTransportPrice.setText("包邮");
            } else {
                holder.tvTransportPrice.setText("￥" + df.format(data.get(position).getFreight()));
            }
            if (data.get(position).isSupportInvoice()) {
                holder.llIsReceipt.setVisibility(View.VISIBLE);
            } else {
                holder.llIsReceipt.setVisibility(View.GONE);
            }
            if (data.get(position).isReceipt()) {
                holder.llOpenReceipt.setVisibility(View.VISIBLE);
            } else {
                holder.llOpenReceipt.setVisibility(View.GONE);
            }
            holder.imags.setImageURI(data.get(position).getImageUrl());
            final int finalPosition = position;
            holder.mMessage.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    data.get(finalPosition).setMessgae(s.toString());
                }
            });
            holder.receipt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    data.get(finalPosition).setReceipt(s.toString());
                }
            });
            holder.ivClear.setOnClickListener(new MyPort(position, holder));
            holder.isReceiptCB.setOnClickListener(new MyPort(position, holder));
        }
    }

    /**
     * 获得单个店铺商品的数量 和总价
     */

    private void getShopGoodsCount(int position, MyHolder holder) {
        int counts = 0;
        double price = data.get(position).getOrderTotalPayAmount();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(position).getShopId() == data.get(i).getShopId()) {
                counts = counts + data.get(i).getQuantity();
            }
        }
        holder.tvConfirmCount.setText("共" + counts + "件商品");
        holder.tvTotalPrice.setText("￥" + df.format(price));
    }

    class MyPort implements View.OnClickListener {
        private int position;
        private MyHolder holder;

        public MyPort(int position, MyHolder holder) {
            this.position = position;
            this.holder = holder;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_check_receipt:
                    if (holder.isReceiptCB.isChecked()) {
                        holder.llOpenReceipt.setVisibility(View.VISIBLE);
                        data.get(position).setReceipt(true);
                    } else {
                        holder.llOpenReceipt.setVisibility(View.GONE);
                        data.get(position).setReceipt(false);
                    }
                    break;
                case R.id.iv_receipt_clear:
                    holder.receipt.setText("");
                    break;
            }
            notifyDataSetChanged(); //刷新适配器
        }
    }

    @Override
    public int getItemCount() {
        int count = (data == null ? 0 : data.size());
        if (VIEW_FOOTER != null) {
            count++;
        }

        if (VIEW_HEADER != null) {
            count++;
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            return TYPE_HEADER;
        } else if (isFooterView(position)) {
            return TYPE_FOOTER;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        try {
            if (mRecyclerView == null && mRecyclerView != recyclerView) {
                mRecyclerView = recyclerView;
            }
            ifGridLayoutManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View getLayout(int layoutId) {
        return LayoutInflater.from(context).inflate(layoutId, null);
    }

    public void addHeaderView(View headerView) {
        if (haveHeaderView()) {
            throw new IllegalStateException("hearview has already exists!");
        } else {
            //避免出现宽度自适应
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            headerView.setLayoutParams(params);
            VIEW_HEADER = headerView;
            ifGridLayoutManager();
            notifyItemInserted(0);
        }

    }

    public void addFooterView(View footerView) {
        if (haveFooterView()) {
            throw new IllegalStateException("footerView has already exists!");
        } else {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            footerView.setLayoutParams(params);
            VIEW_FOOTER = footerView;
            ifGridLayoutManager();
            notifyItemInserted(getItemCount() - 1);
        }
    }

    /**
     *
     */
    private void ifGridLayoutManager() {
        if (mRecyclerView == null) return;
        final RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager.SpanSizeLookup originalSpanSizeLookup =
                    ((GridLayoutManager) layoutManager).getSpanSizeLookup();
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (isHeaderView(position) || isFooterView(position)) ?
                            ((GridLayoutManager) layoutManager).getSpanCount() :
                            1;
                }
            });
        }
    }

    private boolean haveHeaderView() {
        return VIEW_HEADER != null;
    }

    public boolean haveFooterView() {
        return VIEW_FOOTER != null;
    }

    private boolean isHeaderView(int position) {
        return haveHeaderView() && position == 0;
    }

    private boolean isFooterView(int position) {
        return haveFooterView() && position == getItemCount() - 1;
    }


    public static class MyHolder extends RecyclerView.ViewHolder {
        public TextView mShopName;
        //    public TextView mEdit;
        /**
         * 留言
         */
        public EditText mMessage;
        /**
         * 发票
         */
        public EditText receipt;

        /**
         * 商品图片
         */
        public SimpleDraweeView imags;
        /**
         * 商品logo
         */
        public ImageView mShopLogo;
        /**
         * 商品价格
         */
        public TextView mPrice;
        /**
         * 店铺商品小计
         */
        public TextView tvConfirmCount;
        /**
         * 店铺商品价格小计
         */
        public TextView tvTotalPrice;
        /**
         * 运费
         */
        public TextView tvTransportPrice;
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
         * 增加点击选中图片的区域
         */
        public LinearLayout mLlGoodsSelect;

        private LinearLayout shopImageSellect;
        /**
         * 店铺头部
         */
        private LinearLayout llShopCartHeader;
        /**
         * 如果是多个同一店铺的商品 底部的信息不显示
         */
        private LinearLayout llConfrimFoot;
        /**
         * 是否有发票
         */
        private LinearLayout llIsReceipt;
        /**
         * 是否打开发票
         */
        private LinearLayout llOpenReceipt;
        /**
         * 发票开关
         */
        private CheckBox isReceiptCB;
        /**
         * 发票清理
         */
        private ImageView ivClear;

        public MyHolder(View view) {
            super(view);
            llIsReceipt = view.findViewById(R.id.ll_isReceipt);
            llOpenReceipt = view.findViewById(R.id.ll_isopenReceipt);
            isReceiptCB = view.findViewById(R.id.iv_check_receipt);
            receipt = view.findViewById(R.id.m_edt_receipt);
            ivClear = view.findViewById(R.id.iv_receipt_clear);
            shopImageSellect = view.findViewById(R.id.ll_shop_select);
            llConfrimFoot = view.findViewById(R.id.ll_confrim_foot);
            llShopCartHeader = view.findViewById(R.id.ll_shopcart_header);
            mShopName = view.findViewById(R.id.tv_shop_name);
            mShopLogo = view.findViewById(R.id.iv_shoplogo);
            // mEdit = view.findViewById(R.id.tv_edit);
            mMessage = view.findViewById(R.id.m_edt_leave);
            tvTotalPrice = view.findViewById(R.id.m_confirm_total_price);
            tvTransportPrice = view.findViewById(R.id.tv_feight);
            tvConfirmCount = view.findViewById(R.id.tv_confirm_count);
            imags = view.findViewById(R.id.adFaceImage);
            mGoodsName = view.findViewById(R.id.tv_goods_name);
            mCount = view.findViewById(R.id.tv_goods_counts);
            mViersion = view.findViewById(R.id.tv_goods_version);
            mPrice = view.findViewById(R.id.tv_sale_price);
            mLlGoodsSelect = view.findViewById(R.id.ll_iamge_check);
        }
    }
}

