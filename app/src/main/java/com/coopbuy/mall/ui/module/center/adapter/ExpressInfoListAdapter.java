package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class ExpressInfoListAdapter extends BaseRecyclerAdapter<Object> {

    private List<Object> list ;

    public ExpressInfoListAdapter(Context ctx, List<Object> list) {
        super(ctx, list);
        this.list = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_express_info_list;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final Object item) {
        View lineTop = holder.getView(R.id.lineTop);
        View lineBottom = holder.getView(R.id.lineBottom);
        View lineDivider = holder.getView(R.id.lineDivider);
        View dotGray = holder.getView(R.id.dotGray);
        View dotOrange = holder.getView(R.id.dotOrange);
        TextView detailInfo = holder.getTextView(R.id.detailInfo);
        TextView time = holder.getTextView(R.id.time);
        if (position == 0) {
            lineTop.setVisibility(View.INVISIBLE);
            dotOrange.setVisibility(View.VISIBLE);
            dotGray.setVisibility(View.GONE);
            detailInfo.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
            time.setTextColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
        } else if (position == list.size() - 1) {
            lineBottom.setVisibility(View.INVISIBLE);
            lineDivider.setVisibility(View.GONE);
        } else {

        }

        // 设置数据

    }
}
