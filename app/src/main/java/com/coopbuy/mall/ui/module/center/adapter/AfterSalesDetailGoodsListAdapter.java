package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AfterSalesDetailResponse;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/19 11:39
 */
public class AfterSalesDetailGoodsListAdapter extends BaseRecyclerAdapter<AfterSalesDetailResponse.ProductsBean> {

    public AfterSalesDetailGoodsListAdapter(Context ctx, List<AfterSalesDetailResponse.ProductsBean> list) {
        super(ctx, list);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_after_sales_detail_goods_list;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final AfterSalesDetailResponse.ProductsBean item) {
        ((SimpleDraweeView) holder.getView(R.id.sdv_image)).setImageURI(Uri.parse(item.getProductImageUrl()));
        holder.getTextView(R.id.tv_goods_name).setText(item.getProductName());
        holder.getTextView(R.id.propertyDesc).setText((TextUtils.isEmpty(item.getProperties()) ? "" : item.getProperties() + " ") +
                (TextUtils.isEmpty(item.getSpecifications()) ? "" : item.getSpecifications()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.gotoActivity(mContext, GoodsDetailActivity.class, item.getSkuId());
            }
        });
    }
}
