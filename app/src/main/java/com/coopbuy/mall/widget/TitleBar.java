package com.coopbuy.mall.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;

/**
 * TitleBar
 * @author ymb
 * Create at 2017/7/21 15:53
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private RelativeLayout rl_back;
    private FrameLayout fl_right;
    private TitleBarClickListener mListener;
    private TextView mTitle, mRightText;
    private ImageView mRightImage;

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.title_bar, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);

        rl_back = (RelativeLayout) mView.findViewById(R.id.titlebar_back);
        fl_right = (FrameLayout) mView.findViewById(R.id.titlebar_right);
        mTitle = (TextView) mView.findViewById(R.id.title);
        mRightText = (TextView) mView.findViewById(R.id.txt_titlebar_right);
        mRightImage = (ImageView) mView.findViewById(R.id.iv_titlebar_right);
        rl_back.setOnClickListener(this);
        fl_right.setOnClickListener(this);
    }

    public void setTitleText(String title) {
        mTitle.setText(title);
    }

    public void setTitleText(int titleResId) {
        mTitle.setText(titleResId);
    }

    public void setRightText(String text) {
        fl_right.setVisibility(VISIBLE);
        mRightImage.setVisibility(GONE);
        mRightText.setVisibility(VISIBLE);
        mRightText.setText(text);
    }

    public void setRightText(int textResId) {
        fl_right.setVisibility(VISIBLE);
        mRightImage.setVisibility(GONE);
        mRightText.setVisibility(VISIBLE);
        mRightText.setText(textResId);
    }

    public void setRightImage(int imageResId) {
        fl_right.setVisibility(VISIBLE);
        mRightImage.setVisibility(VISIBLE);
        mRightText.setVisibility(GONE);
        mRightImage.setImageResource(imageResId);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.titlebar_back:
                mListener.back();
                break;
            case R.id.titlebar_right:
                mListener.right();
                break;
        }
    }

    public void setTitleBarClickListener(TitleBarClickListener listener) {
        mListener = listener;
    }

    public interface TitleBarClickListener {
        void back();
        void right();
    }
}
