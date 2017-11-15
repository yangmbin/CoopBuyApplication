package com.coopbuy.mall.widget.navigation;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.ui.module.home.activity.SearchActivity;
import com.coopbuy.mall.utils.IntentUtils;

/**
 * 搜索结果页面导航栏
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class SearchResultTopBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private Context mContext;
    private FrameLayout mGoBack;
    private TextView mSearchText;
    private TextView mCancel;
    private LinearLayout mSearchLayout;

    public SearchResultTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.search_result_top_bar, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        mGoBack = mView.findViewById(R.id.go_back);
        mSearchText = mView.findViewById(R.id.tv_search);
        mCancel = mView.findViewById(R.id.cancel_btn);
        mSearchLayout = mView.findViewById(R.id.ll_search);

        mGoBack.setOnClickListener(this);
        mCancel.setOnClickListener(this);
        mSearchLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                ((Activity) mContext).finish();
                break;
            case R.id.cancel_btn:
                ((Activity) mContext).finish();
                break;
            case R.id.ll_search:
                IntentUtils.gotoActivity(mContext, SearchActivity.class);
                ((Activity) mContext).finish();
                break;
        }
    }

    public void setSearchText(String text) {
        mSearchText.setText(text);
    }

}
