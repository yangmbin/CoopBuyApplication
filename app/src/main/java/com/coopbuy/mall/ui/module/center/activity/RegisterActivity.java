package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.RegisterModel;
import com.coopbuy.mall.ui.module.center.presenter.RegisterPresenter;
import com.coopbuy.mall.ui.module.center.view.Register_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterModel> implements Register_IView {


    @Bind(R.id.edt_phone)
    EditText edtPhone;
    @Bind(R.id.iv_phone_clear)
    ImageView ivPhoneClear;
    @Bind(R.id.edt_code)
    EditText edtCode;
    @Bind(R.id.iv_code_clear)
    ImageView ivCodeClear;
    @Bind(R.id.cb_agree)
    CheckBox cbAgree;
    @Bind(R.id.btn_next)
    Button btnNext;

    private boolean isPhoneEmpty = false;
    private boolean isCodeEmpty = false;
    //默认同意协议
    private boolean isAgree = true;

    private String mPhone = "";
    private String mCode = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initModel() {
        mModel = new RegisterModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new RegisterPresenter(this, mModel, this);
    }

    @Override
    public void initView() {
        setTitle(R.string.title_regist);
        ivCodeClear.setVisibility(View.VISIBLE);
        ivPhoneClear.setVisibility(View.VISIBLE);
        setInputListener();

    }

    private void setInputListener() {
        edtCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    ivCodeClear.setVisibility(View.VISIBLE);
                } else {
                    ivCodeClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isCodeEmpty = true;
                } else {
                    isCodeEmpty = false;
                }
                setBtnClickState();
            }
        });
        edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    ivPhoneClear.setVisibility(View.VISIBLE);
                } else {
                    ivPhoneClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isPhoneEmpty = true;
                } else {
                    isPhoneEmpty = false;
                }
                setBtnClickState();
            }
        });
    }

    /**
     * 设置btn的点击状态
     */
    private void setBtnClickState() {
        if (isCodeEmpty && isPhoneEmpty && isAgree) {
            btnNext.setClickable(true);
            btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
        } else {
            btnNext.setClickable(false);
            btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
        }
    }

    @Override
    public void registerSuccess() {

    }

    @Override
    public void onTimeTick(long time) {

    }

    @Override
    public void onTimeFinish() {

    }

    @OnClick({R.id.iv_phone_clear, R.id.iv_code_clear, R.id.tv_get_code, R.id.cb_agree, R.id.tv_protocol, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_phone_clear:
                edtPhone.setText("");
                break;
            case R.id.iv_code_clear:
                edtCode.setText("");
                break;
            case R.id.tv_get_code:
                if (checkPhone()) {

                }
                break;
            case R.id.cb_agree:
                if (cbAgree.isChecked()) {
                    isAgree = true;
                } else {
                    isAgree = false;
                }
                break;
            case R.id.tv_protocol:

                break;
            case R.id.btn_next:
                if (checkPhoneAndPwd()) {

                }
                break;
        }
    }

    private boolean checkPhoneAndPwd() {
        mPhone = edtPhone.getText().toString().trim();
        mCode = edtCode.getText().toString().trim();
        if (CommonUtils.isEmpty(mPhone)) {
            ToastUtils.toastShort(getString(R.string.lab_login_enter_phone));
            return false;
        }
        if (!CommonUtils.isMobileNO(mPhone)) {
            ToastUtils.toastShort(getString(R.string.label_phone_iseorr));
            return false;
        }
        if (CommonUtils.isEmpty(mCode)) {
            ToastUtils.toastShort("验证码不能为空");
            return false;
        }
        return true;
    }

    private boolean checkPhone() {
        mPhone = edtPhone.getText().toString().trim();
        if (CommonUtils.isEmpty(mPhone)) {
            ToastUtils.toastShort(getString(R.string.lab_login_enter_phone));
            return false;
        }
        if (!CommonUtils.isMobileNO(mPhone)) {
            ToastUtils.toastShort(getString(R.string.label_phone_iseorr));
            return false;
        }
        return true;
    }
}
