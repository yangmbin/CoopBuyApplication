package com.coopbuy.mall.ui.mainpage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;

public class HomeLayout1Adapter extends DelegateAdapter.Adapter {

    private Context mContext;
    private LinearLayoutHelper mHelper;

    public HomeLayout1Adapter(Context context) {
        mContext = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        mHelper = new LinearLayoutHelper();
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new MyViewHolder(inflater.inflate(R.layout.item_1_home, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position % 2 == 0) {
            holder.itemView.setBackgroundColor(0xaa3F51B5);
        } else {
            holder.itemView.setBackgroundColor(0xccFF4081);
        }
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.name.setText("Test " + position + "");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
