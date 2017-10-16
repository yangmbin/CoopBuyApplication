package com.coopbuy.mall.ui.module.home.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CategoryResponse;

import java.util.List;

/**
 * 分类左边列表适配器
 * @author ymb
 * Create at 2017/8/1 15:21
 */
public class CategoryLeftAdapter extends BaseAdapter {

    private Context mContext;
    private int mSelect = 0; // 选中项
    private List<CategoryResponse> datas;

    public CategoryLeftAdapter(Context mContext, List<CategoryResponse> datas) {
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

        if (mSelect == position) {
            holder.v_indicator_rec.setVisibility(View.VISIBLE);
            holder.tv_name.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_title_orange));
            holder.rl_item_view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
        } else {
            holder.v_indicator_rec.setVisibility(View.INVISIBLE);
            holder.tv_name.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
            holder.rl_item_view.setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_back_white));
        }

        // 设置数据
        holder.tv_name.setText(datas.get(position).getName());
        // 为List的View设置Tag，用于点击后右边列表跳转
        int jumpPos = 0;
        for (int i = 0; i < position; i++) {
            if (datas.get(i).isIsRecommend()) {
                jumpPos += datas.get(i).getChildren().size();
            } else {
                jumpPos++;
                jumpPos += datas.get(i).getChildren().size();
                for (int j = 0; j < datas.get(i).getChildren().size(); j++) {
                    jumpPos += datas.get(i).getChildren().get(j).getChildren().size();
                }
            }
        }
        convertView.setTag(R.id.jumpPos, jumpPos);

        return convertView;
    }

    /**
     * 刷新方法
     * @param position
     */
    public boolean changeSelected(ListView listView, int position) {
        if (position != mSelect) {
            mSelect = position;
            notifyDataSetChanged();
            listView.smoothScrollToPosition(position);
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
