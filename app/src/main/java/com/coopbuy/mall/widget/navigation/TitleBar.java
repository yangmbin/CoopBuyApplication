package com.coopbuy.mall.widget.navigation;

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
 *
 * @author ymb
 *         Create at 2017/7/21 15:53
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {

    private View mView;
    private RelativeLayout rl_back;
    private FrameLayout fl_right;
    private TitleBarClickListener mListener;
    private TextView mTitle, mRightText;
    private ImageView mRightImage;
    private ImageView mIvLogo;

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
        mIvLogo = (ImageView) mView.findViewById(R.id.iv_logo);
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

    private void setTitleBack() {
        mTitle.setBackgroundResource(R.mipmap.default_img);
    }

    /**
     * 设置html 的标题图片显示
     * @param isVisible
     */
    public void setHtmlLogo(boolean isVisible) {
        if (isVisible) {
            mIvLogo.setVisibility(VISIBLE);
        } else {
            mIvLogo.setVisibility(GONE);
        }
    }

    public void setRightText(int textResId) {
        fl_right.setVisibility(VISIBLE);
        mRightImage.setVisibility(GONE);
        mRightText.setVisibility(VISIBLE);
        mRightText.setText(textResId);
    }

    public String getRightText() {
        return mRightText.getText().toString().trim();
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
                mListener.clickTitleBarBack();
                break;
            case R.id.titlebar_right:
                mListener.clickTitleBarRight();
                mListener.clickTitleBarRight(view);
                break;
        }
    }

    public void setTitleBarClickListener(TitleBarClickListener listener) {
        mListener = listener;
    }

    public interface TitleBarClickListener {
        void clickTitleBarBack();

        void clickTitleBarRight();

        void clickTitleBarRight(View v);
    }
}
