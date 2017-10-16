package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.bean.CenterData;
import com.coopbuy.mall.ui.module.center.activity.DataAnalyseActivity;
import com.coopbuy.mall.ui.module.center.activity.MyCustomActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.List;

/**
 * @author csn
 * @date 2017/9/30 0030 14:21
 * @content
 */
public class CenterAdapter extends BaseRecyclerAdapter<CenterData> {

    public CenterAdapter(Context ctx, List<CenterData> list) {
        super(ctx, list);
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_center;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, final CenterData item) {
        TextView name = holder.getTextView(R.id.tv_name);
        name.setText(item.getName());
        final ImageView image = holder.getImageView(R.id.iv_image);
        image.setImageResource(item.getImages());
        LinearLayout cneter = (LinearLayout) holder.getView(R.id.ll_center);
        cneter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (item.getName()) {
                    case "数据军师":
                        IntentUtils.gotoActivity(mContext, DataAnalyseActivity.class);
                        break;
                    case "我的客户":
                        IntentUtils.gotoActivity(mContext, MyCustomActivity.class);
                        break;
                    case "客户订单":

                        break;
                    case "站长业务":

                        break;
                    case "我的推荐":

                        break;
                }
                ToastUtils.toastShort(item.getName());
            }
        });
    }
}
