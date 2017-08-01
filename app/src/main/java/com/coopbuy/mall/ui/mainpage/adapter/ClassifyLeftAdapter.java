package com.coopbuy.mall.ui.mainpage.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coopbuy.mall.R;

import java.util.List;

/**
 * 分类左边列表适配器
 * @author ymb
 * Create at 2017/8/1 15:21
 */
public class ClassifyLeftAdapter extends BaseAdapter {

    private Context mContext;
    private int mSelect = 0; // 选中项
    private List<Object> datas;

    public ClassifyLeftAdapter(Context mContext, List<Object> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_classify_left_list, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.type_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_name.setText((String) datas.get(position));

        if (mSelect == position) {
            holder.tv_name.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        } else {
            holder.tv_name.setTextColor(Color.parseColor("#323437"));
        }
        return convertView;
    }

    /**
     * 刷新方法
     * @param positon
     */
    public void changeSelected(int positon) {
        if (positon != mSelect) {
            mSelect = positon;
            notifyDataSetChanged();
        }
    }

    static class ViewHolder {
        private TextView tv_name;
    }
}
