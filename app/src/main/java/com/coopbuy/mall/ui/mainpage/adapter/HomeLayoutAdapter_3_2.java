package com.coopbuy.mall.ui.mainpage.adapter;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.HomeFloorResponse;
import com.coopbuy.mall.base.BaseDelegateAdapter;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeLayoutAdapter_3_2 extends BaseDelegateAdapter<HomeFloorResponse> {


    public HomeLayoutAdapter_3_2(Context ctx, List<HomeFloorResponse> list, LayoutHelper mLayoutHelper) {
        super(ctx, list, mLayoutHelper);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_3_2_home;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final HomeFloorResponse item) {
        RecyclerView recyclerView = (RecyclerView) holder.getView(R.id.mRecycleView);
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        HorizontalAdapter adapter = new HorizontalAdapter(mContext, item.getFloorItems());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    class HorizontalAdapter extends BaseRecyclerAdapter<HomeFloorResponse.FloorItemsBean> {

        public HorizontalAdapter(Context ctx, List<HomeFloorResponse.FloorItemsBean> list) {
            super(ctx, list);
        }

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.list_item_3_2_home;
        }

        @Override
        protected void bindData(BaseRecyclerHolder holder, final int position, final HomeFloorResponse.FloorItemsBean item) {
            ((SimpleDraweeView) holder.getView(R.id.image)).setImageURI(Uri.parse(item.getImageUrl()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    IntentUtils.gotoActivityFromHome(mContext, item.getType(), item);
                }
            });
        }
    }
}
