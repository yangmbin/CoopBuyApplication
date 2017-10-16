package com.coopbuy.mall.ui.module.center.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.request.LoginRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.RegisterEvent;
import com.coopbuy.mall.ui.module.center.model.LoginModel;
import com.coopbuy.mall.ui.module.center.presenter.LoginPresenter;
import com.coopbuy.mall.ui.module.center.view.Login_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.FinalConstant;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.PicCodeUtil;
import com.coopbuy.mall.utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
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
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.iv_imagecode_clear)
    ImageView ivImagecodeClear;
    @Bind(R.id.iv_imagecode)
    ImageView ivImagecode;
    @Bind(R.id.edit_imagecode)
    EditText mEditImagecode;

    private LoginRequest request;

    private String mPhone;
    private String mPwd;
    private String mImageCode;

    private boolean isPhoneEmpty = false;
    private boolean isPasswordEmpty = false;
    private boolean isImageEmpty = false;
    private boolean isNeedCode = false;

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
        EventBusInstance.getInstance().registerEvent(this);
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
        setInputListener();
    }

    private void setInputListener() {
        mEditPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    ivPasswordClear.setVisibility(View.VISIBLE);
                } else {
                    ivPasswordClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isPasswordEmpty = true;
                } else {
                    isPasswordEmpty = false;
                }
                setBtnClickState();
            }
        });
        mEditPhone.addTextChangedListener(new TextWatcher() {
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
        mEditImagecode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    ivImagecodeClear.setVisibility(View.VISIBLE);
                } else {
                    ivImagecodeClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isImageEmpty = true;
                } else {
                    isImageEmpty = false;
                }
                setBtnClickState();
            }
        });
    }

    /**
     * 设置btn的点击状态
     */
    private void setBtnClickState() {
        if (isPasswordEmpty && isPhoneEmpty) {
            if (isNeedCode) {
                if (isImageEmpty) {
                    btnLogin.setClickable(true);
                    btnLogin.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
                } else {
                    btnLogin.setClickable(false);
                    btnLogin.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
                }
            } else {
                btnLogin.setClickable(true);
                btnLogin.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
            }

        } else {
            btnLogin.setClickable(false);
            btnLogin.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
        }
    }

    @OnClick({R.id.iv_phone_clear, R.id.iv_password_clear, R.id.iv_visible, R.id.btn_login, R.id.tv_register, R.id.tv_forget_password, R.id.iv_imagecode_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_phone_clear:
                mEditPhone.setText("");
                break;
            case R.id.iv_password_clear:
                mEditPassword.setText("");
                break;
            case R.id.iv_imagecode_clear:
                mEditImagecode.setText("");
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
                    if (isNeedCode) {
                        request.setVerificationCode(mImageCode);
                    }
                    mPresenter.login(request);
                }
                break;
            case R.id.tv_register:
                IntentUtils.gotoActivity(this, RegisterActivity.class);
                break;
            case R.id.tv_forget_password:
                IntentUtils.gotoActivity(this, SetPassWordActivity.class, Constants.FORGET_TYPE);
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
        if (isNeedCode) {
            mImageCode = mEditImagecode.getText().toString().trim();
            if (CommonUtils.isEmpty(mImageCode)) {
                ToastUtils.toastShort("图形验证码不能为空");
                return false;
            }
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
    public void loginFail(String msg, boolean isNeedCode) {
        this.isNeedCode = isNeedCode;
        if (isNeedCode) {
            llPasswordErrorShow.setVisibility(View.VISIBLE);
            mPresenter.getImageCode(mPhone);
        } else {
            llPasswordErrorShow.setVisibility(View.GONE);
        }
        ToastUtils.toastShort(msg);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void getImageCode(String code) {
        ivImagecode.setBackground(PicCodeUtil.byteToDrawable(code));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(RegisterEvent event) {
        if (event != null) {
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }
}

