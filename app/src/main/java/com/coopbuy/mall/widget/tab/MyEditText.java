package com.coopbuy.mall.widget.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.ui.module.center.port.IsEmptyPort;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 导航组合控件
 */
public class MyEditText extends LinearLayout implements View.OnFocusChangeListener, TextWatcher, View.OnClickListener {
    @Bind(R.id.iv_my_clear)
    ImageView mClear;
    @Bind(R.id.edt_myname)
    EditText mEdit;
    private Context mContext;
    /**
     * 得到edit是否为空的回调 设置下一步 按钮的状态
     */
    private IsEmptyPort port;
    /**
     * @说明:控件是否获得焦点
     * @名称:hasFoucs
     * @类型:boolean
     */
    private boolean hasFoucs;
    private boolean isEmpty = false;
    private View v;

    public void setIsEmptyPort(IsEmptyPort port) {
        this.port = port;
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        v = LayoutInflater.from(context).inflate(R.layout.my_editext_view, this);
        ButterKnife.bind(this);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabView);
        float textSize = typedArray.getDimension(R.styleable.TabView_textSize, 16);
        Drawable iconDrawable = typedArray.getDrawable(R.styleable.TabView_iconDrawable);
        String text = typedArray.getString(R.styleable.TabView_text);
        String dotText = typedArray.getString(R.styleable.TabView_dotText);
        int inputType = typedArray.getInt(R.styleable.TabView_inputType, InputType.TYPE_CLASS_TEXT);
        int textGravity = typedArray.getInt(R.styleable.TabView_textGravity, Gravity.CENTER | Gravity.LEFT);
        String hintText = typedArray.getString(R.styleable.TabView_hint);
    /*    int textColor = typedArray.getColor(R.styleable.TabView_textColor, R.drawable.edit_textcolor_selector);
        int textHintColor = typedArray.getColor(R.styleable.TabView_hintColor, R.drawable.edit_textcolor_selector);*/
        setTextSize(textSize);
        setText(text);
        setinputType(inputType);
        // setTextColor(textColor);
        // setHintColor(textHintColor);
        setHintText(hintText);
        typedArray.recycle();
  /*      mEdit.setInputType(InputType.TYPE_CLASS_PHONE);
        mEdit.setInputType(InputType.TYPE_CLASS_TEXT);
        mEdit.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        mEdit.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        mEdit.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        mEdit.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD);*/
        setEditGravity(textGravity);
        mClear.setOnClickListener(this);
        mEdit.setOnFocusChangeListener(this);
        mEdit.addTextChangedListener(this);
    }

    public void setText(String text) {
        mEdit.setText(text);
    }

    public void setText(int text) {
        mEdit.setText(mContext.getString(text));
    }

    public void setHintText(String text) {
        mEdit.setHint(text);
    }

    public void setHintText(int text) {
        mEdit.setHint(mContext.getString(text));
    }

    public void setTextColor(int textColor) {
        mEdit.setTextColor(textColor);
    }

    public String getText() {
        return mEdit.getText().toString().trim();
    }

    public void setHintColor(int textColor) {
        mEdit.setTextColor(textColor);
    }

    public void setinputType(int textColor) {
        mEdit.setInputType(textColor);
    }

    public void setEditGravity(int textColor) {
        mEdit.setGravity(textColor);
    }

    public void setTextSize(float textSize) {
        mEdit.setTextSize(textSize);
    }

    /**
     * 设置txt是否可见
     *
     * @param visible
     */
    public void setTextPasswordVisible(boolean visible) {
        if (visible) {
            mEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            mEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
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
        if (!TextUtils.isEmpty(editable.toString())) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        if (port != null) {
            port.setIsEmptyPort(v, isEmpty);
        }
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

    public boolean isTextEmpty() {
        return isEmpty;
    }
}
