package com.coopbuy.mall.ui.module.test.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.test.port.ClickPort;

import java.util.List;

/**
 * @author csn
 * @date 2017/8/2 0002 15:50
 * @content
 */
public class TestAdapter extends BaseRecyclerAdapter<String> {
    private ClickPort port;
    private List<String> mData;

    public TestAdapter(Context ctx, List<String> list, ClickPort port) {
        super(ctx, list);
        this.mData = list;
        this.port = port;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.item_test_api;
    }

    @Override
    protected void bindData(BaseRecyclerHolder holder, int position, String item) {
        TextView tvName = holder.getTextView(R.id.tv_test_name);
        holder.getTextView(R.id.tv_test_look).setOnClickListener(new MyListener(position));
        tvName.setText(mData.get(position));
    }

    class MyListener implements View.OnClickListener {
        private int position;

        public MyListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            port.getPosition(position,mData.get(position));
        }
    }
}
