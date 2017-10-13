package com.coopbuy.mall.ui.module.center.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.login.LoginRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.LoginModel;
import com.coopbuy.mall.ui.module.center.presenter.LoginPresenter;
import com.coopbuy.mall.ui.module.center.view.Login_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.FinalConstant;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements Login_IView {

    //控制activity跳转类型
    private static int mSkip_type = FinalConstant.login_type_normal;//默认正常跳转
    private static int mOnclickType = -1;
    /**
     * 账号输入
     */
    @Bind(R.id.edit_phone)
    EditText mEditPhone;

    /**
     * 密码输入
     */
    @Bind(R.id.edit_password)
    EditText mEditPassword;
    /**
     * 注册
     */
    @Bind(R.id.tv_register)
    TextView mTvRegister;
    /**
     * 忘记密码
     */
    @Bind(R.id.tv_forget_password)
    TextView mTvForgetPassword;
    @Bind(R.id.ll_password_error_show)
    LinearLayout llPasswordErrorShow;

    @Bind(R.id.iv_visible)
    CheckBox mPassVisible;

    @Bind(R.id.iv_phone_clear)
    ImageView ivPhoneClear;
    @Bind(R.id.iv_password_clear)
    ImageView ivPasswordClear;
    @Bind(R.id.iv_imagecode_clear)
    ImageView ivImagecodeClear;

    private LoginRequest request;

    private String mPhone;
    private String mPwd;
    private String mImageCode;
    /**
     * 次数记录
     */
    private int times;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initModel() {
        mModel = new LoginModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new LoginPresenter(this, mModel, this);
    }

    @Override
    public void initView() {
        times = 0;
        llPasswordErrorShow.setVisibility(View.GONE);
        ivPhoneClear.setVisibility(View.GONE);
        ivPasswordClear.setVisibility(View.GONE);
        ivImagecodeClear.setVisibility(View.GONE);
        //下划线
        mTvRegister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTvRegister.getPaint().setAntiAlias(true);
        mTvForgetPassword.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTvForgetPassword.getPaint().setAntiAlias(true);
        setTitle(getString(R.string.title_login));

    }
    private void setInputListener(){
        mEditPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>0){
                    ivPasswordClear.setVisibility(View.VISIBLE);
                }else {
                    ivPasswordClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mEditPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>0){
                    ivPhoneClear.setVisibility(View.VISIBLE);
                }else {
                    ivPhoneClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @OnClick({R.id.iv_phone_clear, R.id.iv_password_clear, R.id.iv_visible, R.id.btn_login, R.id.tv_register, R.id.tv_forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_phone_clear:
                mEditPhone.setText("");
                break;
            case R.id.iv_password_clear:
                mEditPhone.setText("");
                break;
            case R.id.iv_visible:
                if (mPassVisible.isChecked()) {
                    mEditPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    mEditPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.btn_login:
                if (checkPhoneAndPwd()) {
                    request = new LoginRequest();
                    request.setPassword(mPwd);
                    request.setUserName(mPhone);
                    request.setVerificationCode(mImageCode);
                    mPresenter.login(request);
                    times++;
                }
                break;
            case R.id.tv_register:
                IntentUtils.gotoActivity(this, RegisterActivity.class);
                break;
            case R.id.tv_forget_password:
                IntentUtils.gotoActivity(this, SetPassWordActivity.class);
                break;
        }
    }

    /**
     * 检查手机号和密码
     **/
    private boolean checkPhoneAndPwd() {
        mPhone = mEditPhone.getText().toString().trim();
        mPwd = mEditPassword.getText().toString().trim();
        if (CommonUtils.isEmpty(mPhone)) {
            ToastUtils.toastShort(getString(R.string.lab_login_enter_phone));
            return false;
        }
        if (!CommonUtils.isMobileNO(mPhone)) {
            ToastUtils.toastShort(getString(R.string.label_phone_iseorr));
            return false;
        }
        if (CommonUtils.isEmpty(mPwd)) {
            ToastUtils.toastShort("密码不能为空");
            return false;
        }
        return true;
    }

    /**
     * 创建intent 控制从mainActivity跳转至当前页面
     *
     * @param context 上下文
     * @return
     */
    public static Intent newIntentMeActivity(Context context, int type, int clickType) {
        Intent newIntent = new Intent(context, LoginActivity.class);
        mSkip_type = type;
        mOnclickType = clickType;
        context.startActivity(newIntent);
        return newIntent;
    }

    @Override
    public void loginSuccess() {
        sharedPreferencesUtils.saveLoginStatus();
    }

    @Override
    public void loginFail(String msg) {
        if (times > 5) {
            llPasswordErrorShow.setVisibility(View.VISIBLE);
        } else {
            llPasswordErrorShow.setVisibility(View.GONE);
        }
    }


}

