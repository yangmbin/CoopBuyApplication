package com.coopbuy.mall.widget.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 * 导航组合控件
 */
public class MainTabView extends LinearLayout {
    @Bind(R.id.main_tab_iv)
    ImageView tabIcon;
    @Bind(R.id.main_tab_num)
    TextView tabNum;
    @Bind(R.id.main_tab_name)
    TextView tabName;
    private Context mContext;
    public MainTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_maintab, this);
        ButterKnife.bind(this);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabView);
        float textSize = typedArray.getDimension(R.styleable.TabView_textSize, 12);
        Drawable iconDrawable = typedArray.getDrawable(R.styleable.TabView_iconDrawable);
        String text = typedArray.getString(R.styleable.TabView_text);
        String dotText = typedArray.getString(R.styleable.TabView_dotText);
        int textColor = typedArray.getColor(R.styleable.TabView_textColor, R.drawable.tab_textcolor_selector);
        setTextSize(textSize);
        setText(text);
        setTextColor(textColor);
        setIconDrable(iconDrawable);
        if (!TextUtils.isEmpty(dotText)) {
            tabNum.setVisibility(View.VISIBLE);
        } else {
            tabNum.setVisibility(View.GONE);
        }
        typedArray.recycle();

    }

    public void setDotText(String _dotText){
        if (!TextUtils.isEmpty(_dotText)) {
            tabNum.setVisibility(View.VISIBLE);
        }else{
            tabNum.setVisibility(View.GONE);
        }
    }
    public void setDotText(int _dotText) {
        if (_dotText > 0 && _dotText <= 99) {
            tabNum.setText(String.valueOf(_dotText));
            tabNum.setVisibility(View.VISIBLE);
        } else if (_dotText > 99) {
            tabNum.setText("99");
            tabNum.setVisibility(View.VISIBLE);
        } else {
            tabNum.setVisibility(View.GONE);
        }
    }
    public void setIconDrable(Drawable iconDrawable) {
        tabIcon.setImageDrawable(iconDrawable);
    }

    public void setIconDrable(int _iconDrawable) {
        tabIcon.setImageResource(_iconDrawable);
    }

    public void setIconDrable(Bitmap _iconDrawable) {
        tabIcon.setImageBitmap(_iconDrawable);
    }
    public void setText(String text) {
        tabName.setText(text);
    }

    public void setText(int text) {
        tabName.setText(mContext.getString(text));
    }

    public void setTextColor(int textColor) {
        tabName.setTextColor(textColor);
    }

    public void setTextSize(float textSize) {
        tabName.setTextSize(textSize);
    }

}
