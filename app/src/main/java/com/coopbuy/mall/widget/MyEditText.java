package com.coopbuy.mall.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;

/**
 * @author csn
 * @date 2017/10/18 0018 15:17
 * @content
 */
public class MyEditText extends RelativeLayout implements View.OnFocusChangeListener {
    private Context mContext;
    private View mView;
    private EditText mEdit;
    private ImageView mIvClear;
    private CheckBox mVisible;

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.myedittext_layout, null);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mView.setLayoutParams(params);
        addView(mView);
        init();
    }


    private void init() {
        mEdit = (EditText) mView.findViewById(R.id.edit_name);
        mIvClear = (ImageView) mView.findViewById(R.id.iv_name_clear);
        mVisible = (CheckBox) mView.findViewById(R.id.iv_visible);
    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

}
