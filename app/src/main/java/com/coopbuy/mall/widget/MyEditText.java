package com.coopbuy.mall.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;


/**
 * @author csn
 * @date 2017/10/18 0018 15:17
 * @content
 */
public class MyEditText extends RelativeLayout implements View.OnFocusChangeListener, TextWatcher, View.OnClickListener {
    private Context mContext;
    private String mHint;
    private ImageView mClear;
    private EditText mEdit;
    /**
     * @说明:控件是否获得焦点
     * @名称:hasFoucs
     * @类型:boolean
     */
    private boolean hasFoucs;

    public MyEditText(Context context) {
        super(context, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        View v = LayoutInflater.from(context).inflate(R.layout.my_editext_view, this);
        v.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mClear = (ImageView) findViewById(R.id.iv_my_clear);
        mEdit = (EditText) findViewById(R.id.edt_myname);
        RelativeLayout rl = v.findViewById(R.id.rl);
        RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) rl.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) mEdit.getLayoutParams();
        layoutParams1.height = 90;
        layoutParams2.height = 90;
        rl.setLayoutParams(layoutParams1);
        mEdit.setLayoutParams(layoutParams2);


        mClear.setOnClickListener(this);
        mEdit.setOnFocusChangeListener(this);
        mEdit.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (hasFoucs) {
            setClearIconVisible(charSequence.length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        this.hasFoucs = hasFocus;
        if (hasFocus) {
            setClearIconVisible(mEdit.getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    protected void setClearIconVisible(boolean visible) {
        if (visible) {
            mClear.setVisibility(VISIBLE);
        } else {
            mClear.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View view) {
        mEdit.setText("");
    }
}