package com.coopbuy.mall.ui.module.center.adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ExpressInfoResponse;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;

import java.util.List;

public class ExpressInfoListAdapter extends BaseRecyclerAdapter<ExpressInfoResponse.NodesBean> {

    private List<ExpressInfoResponse.NodesBean> list ;

    public ExpressInfoListAdapter(Context ctx, List<ExpressInfoResponse.NodesBean> list) {
        super(ctx, list);
        this.list = list;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_express_info_list;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final ExpressInfoResponse.NodesBean item) {
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
        }

        // 设置数据
        holder.getTextView(R.id.detailInfo).setText("[" + item.getAcceptStation() + "]" + item.getRemark());
        holder.getTextView(R.id.time).setText(item.getAcceptTime());
    }
}
