package com.coopbuy.mall.ui.module.home.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;

import java.util.List;

/**
 * 分类左边列表适配器
 * @author ymb
 * Create at 2017/8/1 15:21
 */
public class CategoryLeftAdapter extends BaseAdapter {

    private Context mContext;
    private int mSelect = 0; // 选中项
    private List<Object> datas;

    public CategoryLeftAdapter(Context mContext, List<Object> datas) {
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
            convertView = View.inflate(mContext, R.layout.item_category_left_list, null);
            holder = new ViewHolder();
            holder.v_indicator_rec = convertView.findViewById(R.id.indicator_rect);
            holder.tv_name = (TextView) convertView.findViewById(R.id.type_name);
            holder.rl_item_view = (RelativeLayout) convertView.findViewById(R.id.item_view);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.tv_name.setText((String) datas.get(position));

        if (mSelect == position) {
            holder.v_indicator_rec.setVisibility(View.VISIBLE);
            holder.tv_name.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
            holder.rl_item_view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
        } else {
            holder.v_indicator_rec.setVisibility(View.INVISIBLE);
            holder.tv_name.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
            holder.rl_item_view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_back_white));
        }
        return convertView;
    }

    /**
     * 刷新方法
     * @param position
     */
    public boolean changeSelected(int position) {
        if (position != mSelect) {
            mSelect = position;
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    static class ViewHolder {
        private View v_indicator_rec;
        private TextView tv_name;
        private RelativeLayout rl_item_view;
    }
}
