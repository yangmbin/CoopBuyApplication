package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.bean.CenterData;
import com.coopbuy.mall.ui.mainpage.fragment.ThreeFragment;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.List;
import java.util.Map;

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
                ToastUtils.toastShort(item.getName());
            }
        });
    }
}
