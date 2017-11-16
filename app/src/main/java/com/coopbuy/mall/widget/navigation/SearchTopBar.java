package com.coopbuy.mall.widget.navigation;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;

/**
 * 搜索页面导航栏
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class SearchTopBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private Context mContext;
    private FrameLayout mGoBack;
    private EditText mSearchEdit;
    private TextView mSearch;
    private ImageView mClearSearch;
    private SearchListener mSearchListener;

    public SearchTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.search_top_bar, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        mGoBack = mView.findViewById(R.id.go_back);
        mSearchEdit = mView.findViewById(R.id.et_search);
        mSearch = mView.findViewById(R.id.search_btn);
        mClearSearch = mView.findViewById(R.id.clear_search);

        mGoBack.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        mClearSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                ((Activity) mContext).finish();
                break;
            case R.id.search_btn:
                mSearchListener.search();
                break;
            case R.id.clear_search:
                mSearchEdit.setText("");
                break;
        }
    }

    public String getSearchText() {
        return mSearchEdit.getText().toString().trim();
    }

    public void setOnSearchListener(SearchListener listener) {
        mSearchListener = listener;
    }

    public interface SearchListener {
        void search();
    }

}
