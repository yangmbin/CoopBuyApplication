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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;

import java.util.List;

/**
 * Created by YOLANDA on 2016/7/22.
 */
public class PayHistoryAdapter extends RecyclerView.Adapter<PayHistoryAdapter.ViewHolder> {

    private List<MessageCenterResponse> mData;

    public PayHistoryAdapter(List<MessageCenterResponse> titles) {
        this.mData = titles;
    }

    public void flesh(List<MessageCenterResponse> data) {
        if (!this.mData.isEmpty()) {
            this.mData.clear();
        }
        this.mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addMore(List<MessageCenterResponse> data) {
        this.mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payhistory_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(mData.get(position).getName());

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mPayName;
        TextView mPayTime;
        TextView mPayPrice;
        TextView mPayHistoryStatus;
        ImageView mPayStatusIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            mPayName = (TextView) itemView.findViewById(R.id.tv_payanther_name);
            mPayTime = (TextView) itemView.findViewById(R.id.tv_payanther_time);
            mPayPrice = (TextView) itemView.findViewById(R.id.tv_payanther_price);
            mPayHistoryStatus = (TextView) itemView.findViewById(R.id.tv_payanther_hint);
            mPayStatusIcon = itemView.findViewById(R.id.tv_payanther_status);
        }

        public void setData(String title) {
            this.mPayName.setText(title);
        }
    }
}
