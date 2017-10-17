package com.coopbuy.mall.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;

/**
 * 客户订单列表顶部
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class NavOrderListBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private Context mContext;
    private FrameLayout fl_goback, fl_more;

    public NavOrderListBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.nav_order_list_top, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        fl_goback = (FrameLayout) mView.findViewById(R.id.go_back);
        fl_more = (FrameLayout) mView.findViewById(R.id.more_btn);

        fl_goback.setOnClickListener(this);
        fl_more.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                ((Activity) mContext).finish();
                break;
            case R.id.more_btn:

                break;
        }
    }
}
