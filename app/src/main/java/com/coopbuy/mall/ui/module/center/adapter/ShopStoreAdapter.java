/*
 * Copyright 2016 Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.coopbuy.mall.ui.module.center.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShopStoreReponse;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by YOLANDA on 2016/7/22.
 */
public class ShopStoreAdapter extends RecyclerView.Adapter<ShopStoreAdapter.ViewHolder> {

    private List<ShopStoreReponse.ItemsBean> mData;

    public ShopStoreAdapter(List<ShopStoreReponse.ItemsBean> titles) {
        this.mData = titles;
    }

    public void flesh(List<ShopStoreReponse.ItemsBean> data) {
        if (!this.mData.isEmpty()) {
            this.mData.clear();
        }
        this.mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addMore(List<ShopStoreReponse.ItemsBean> data) {
        this.mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopstore_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(mData.get(position).getShopName());
        holder.setImages(mData.get(position).getLogoImageUrl());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopName;
        SimpleDraweeView shopLogo;


        public ViewHolder(View itemView) {
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.tv_shop_name);
            shopLogo = itemView.findViewById(R.id.shopstore_image);
        }

        public void setData(String title) {
            this.shopName.setText(title);
        }

        public void setImages(String url) {
            if (TextUtils.isEmpty(url)) {
                url = "http://himg2.huanqiu.com/attachment2010/2017/0920/10/29/20170920102911518.jpg";
            }
            this.shopLogo.setImageURI(url);
        }
    }

}
