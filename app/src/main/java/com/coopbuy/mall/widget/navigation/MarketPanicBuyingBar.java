package com.coopbuy.mall.widget.navigation;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.ui.mainpage.fragment.MarketDayFragment;

/**
 * 赶场抢购条
 *
 * @author ymb
 *         Create at 2017/7/21 15:53
 */
public class MarketPanicBuyingBar extends RelativeLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;
    private View mIndicator1, mIndicator2, mIndicator3, mIndicator4;
    private LinearLayout mLLTime1, mLLTime2, mLLTime3, mLLTime4;
    private LinearLayout mTextSelected1, mTextSelected2, mTextSelected3, mTextSelected4;
    private TextView mTextUnSelected1, mTextUnSelected2, mTextUnSelected3, mTextUnSelected4;
    private MarketDayFragment marketDayFragment;
    private boolean isFloatTab; // 是否是悬浮Tab

    public MarketPanicBuyingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.market_panic_buying_bar, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        mIndicator1 = findViewById(R.id.indicator_1);
        mIndicator2 = findViewById(R.id.indicator_2);
        mIndicator3 = findViewById(R.id.indicator_3);
        mIndicator4 = findViewById(R.id.indicator_4);

        mLLTime1 = (LinearLayout) findViewById(R.id.ll_time_1);
        mLLTime2 = (LinearLayout) findViewById(R.id.ll_time_2);
        mLLTime3 = (LinearLayout) findViewById(R.id.ll_time_3);
        mLLTime4 = (LinearLayout) findViewById(R.id.ll_time_4);

        mTextSelected1 = (LinearLayout) findViewById(R.id.text_selected_1);
        mTextSelected2 = (LinearLayout) findViewById(R.id.text_selected_2);
        mTextSelected3 = (LinearLayout) findViewById(R.id.text_selected_3);
        mTextSelected4 = (LinearLayout) findViewById(R.id.text_selected_4);

        mTextUnSelected1 = (TextView) findViewById(R.id.text_unselected_1);
        mTextUnSelected2 = (TextView) findViewById(R.id.text_unselected_2);
        mTextUnSelected3 = (TextView) findViewById(R.id.text_unselected_3);
        mTextUnSelected4 = (TextView) findViewById(R.id.text_unselected_4);

        mLLTime1.setOnClickListener(this);
        mLLTime2.setOnClickListener(this);
        mLLTime3.setOnClickListener(this);
        mLLTime4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_time_1:
                selectTab(1, true);
                break;
            case R.id.ll_time_2:
                selectTab(2, true);
                break;
            case R.id.ll_time_3:
                selectTab(3, true);
                break;
            case R.id.ll_time_4:
                selectTab(4, true);
                break;
        }
    }

    public void selectTab(int index, boolean isClickOperation) {

        mIndicator1.setVisibility(VISIBLE);
        mIndicator2.setVisibility(VISIBLE);
        mIndicator3.setVisibility(VISIBLE);
        mIndicator4.setVisibility(VISIBLE);
        mTextSelected1.setVisibility(VISIBLE);
        mTextSelected2.setVisibility(VISIBLE);
        mTextSelected3.setVisibility(VISIBLE);
        mTextSelected4.setVisibility(VISIBLE);
        mTextUnSelected1.setVisibility(VISIBLE);
        mTextUnSelected2.setVisibility(VISIBLE);
        mTextUnSelected3.setVisibility(VISIBLE);
        mTextUnSelected4.setVisibility(VISIBLE);

        switch (index) {
            case 1:
                mIndicator1.setVisibility(VISIBLE);
                mIndicator2.setVisibility(INVISIBLE);
                mIndicator3.setVisibility(INVISIBLE);
                mIndicator4.setVisibility(INVISIBLE);
                mLLTime1.setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
                mLLTime2.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime3.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime4.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mTextSelected1.setVisibility(VISIBLE);
                mTextSelected2.setVisibility(INVISIBLE);
                mTextSelected3.setVisibility(INVISIBLE);
                mTextSelected4.setVisibility(INVISIBLE);
                mTextUnSelected1.setVisibility(INVISIBLE);
                mTextUnSelected2.setVisibility(VISIBLE);
                mTextUnSelected3.setVisibility(VISIBLE);
                mTextUnSelected4.setVisibility(VISIBLE);
                break;
            case 2:
                mIndicator1.setVisibility(INVISIBLE);
                mIndicator2.setVisibility(VISIBLE);
                mIndicator3.setVisibility(INVISIBLE);
                mIndicator4.setVisibility(INVISIBLE);
                mLLTime1.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime2.setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
                mLLTime3.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime4.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mTextSelected1.setVisibility(INVISIBLE);
                mTextSelected2.setVisibility(VISIBLE);
                mTextSelected3.setVisibility(INVISIBLE);
                mTextSelected4.setVisibility(INVISIBLE);
                mTextUnSelected1.setVisibility(VISIBLE);
                mTextUnSelected2.setVisibility(INVISIBLE);
                mTextUnSelected3.setVisibility(VISIBLE);
                mTextUnSelected4.setVisibility(VISIBLE);
                break;
            case 3:
                mIndicator1.setVisibility(INVISIBLE);
                mIndicator2.setVisibility(INVISIBLE);
                mIndicator3.setVisibility(VISIBLE);
                mIndicator4.setVisibility(INVISIBLE);
                mLLTime1.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime2.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime3.setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
                mLLTime4.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mTextSelected1.setVisibility(INVISIBLE);
                mTextSelected2.setVisibility(INVISIBLE);
                mTextSelected3.setVisibility(VISIBLE);
                mTextSelected4.setVisibility(INVISIBLE);
                mTextUnSelected1.setVisibility(VISIBLE);
                mTextUnSelected2.setVisibility(VISIBLE);
                mTextUnSelected3.setVisibility(INVISIBLE);
                mTextUnSelected4.setVisibility(VISIBLE);
                break;
            case 4:
                mIndicator1.setVisibility(INVISIBLE);
                mIndicator2.setVisibility(INVISIBLE);
                mIndicator3.setVisibility(INVISIBLE);
                mIndicator4.setVisibility(VISIBLE);
                mLLTime1.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime2.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime3.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                mLLTime4.setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_text_lab_black));
                mTextSelected1.setVisibility(INVISIBLE);
                mTextSelected2.setVisibility(INVISIBLE);
                mTextSelected3.setVisibility(INVISIBLE);
                mTextSelected4.setVisibility(VISIBLE);
                mTextUnSelected1.setVisibility(VISIBLE);
                mTextUnSelected2.setVisibility(VISIBLE);
                mTextUnSelected3.setVisibility(VISIBLE);
                mTextUnSelected4.setVisibility(INVISIBLE);
                break;
        }

        marketDayFragment.setCurrentTabIndex(index);
        // 点击悬浮Tab，就调用notify刷新非悬浮Tab，实现同步.
        if (isFloatTab && isClickOperation)
            marketDayFragment.notifyAdapter_10();
        // 反之
        else if(!isFloatTab && isClickOperation)
            marketDayFragment.notifyAdapter_9();
    }

    public void setFragment(MarketDayFragment fragment) {
        marketDayFragment = fragment;
    }

    public void setIsFloatTab(boolean isFloatTab) {
        this.isFloatTab = isFloatTab;
    }
}
