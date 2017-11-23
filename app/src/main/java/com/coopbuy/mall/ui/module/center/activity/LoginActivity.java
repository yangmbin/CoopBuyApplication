package com.coopbuy.mall.ui.module.center.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
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
import com.coopbuy.mall.ui.module.center.port.IsEmptyPort;
import com.coopbuy.mall.ui.module.center.presenter.LoginPresenter;
import com.coopbuy.mall.ui.module.center.view.Login_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.FinalConstant;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.PicCodeUtil;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.utils.ViewClickUtil;
import com.coopbuy.mall.widget.tab.MyEditText;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements Login_IView, IsEmptyPort {

    //控制activity跳转类型
    private static int mSkip_type = FinalConstant.login_type_normal;//默认正常跳转
    private static int mOnclickType = -1;
    /**
     * 账号输入
     */
    @Bind(R.id.edit_phone)
    MyEditText mEditPhone;

    /**
     * 密码输入
     */
    @Bind(R.id.edit_password)
    MyEditText mEditPassword;
    @Bind(R.id.edit_imagecode)
    MyEditText mEditImagecode;

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

    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.iv_imagecode)
    ImageView ivImagecode;


    private LoginRequest request;

    private String mPhone;
    private String mPwd;
    private String mImageCode;
    /**
     * 需要跳转的
     */
    private static Class<?> toActivity;
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
        //下划线
        mTvRegister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTvRegister.getPaint().setAntiAlias(true);
        mTvForgetPassword.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTvForgetPassword.getPaint().setAntiAlias(true);
        setTitle(getString(R.string.title_login));
        mEditImagecode.setIsEmptyPort(this);
        mEditPassword.setIsEmptyPort(this);
        mEditPhone.setIsEmptyPort(this);
        //不知道为什么 设置密码不可见 设置不了
        mEditPassword.setTextPasswordVisible(false);
    }


    @OnClick({R.id.iv_visible, R.id.btn_login, R.id.tv_register, R.id.tv_forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_visible:
                mEditPassword.setTextPasswordVisible(mPassVisible.isChecked());
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
                IntentUtils.gotoActivity(this, ForgetPwdActivity.class, Constants.FORGET_TYPE);
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
        //这里需要处理跳转问题
        onBackPressed();

    }

    @Override
    public void loginFail(String msg, boolean isNeedCode) {
        if (!isNeedCode) {//这里像这样做是为了 多次密码失败 再次进入 点击登录时需要输入图形验证码是服务器给的提示
            if (!msg.equals("图片验证码不能为空")) {
                ToastUtils.toastShort(msg);
            }
        } else {
            ToastUtils.toastShort(msg);
        }
        this.isNeedCode = isNeedCode;
        if (isNeedCode) {
            llPasswordErrorShow.setVisibility(View.VISIBLE);
            mPresenter.getImageCode(mPhone);
        } else {
            llPasswordErrorShow.setVisibility(View.GONE);

        }
        if (!isImageEmpty && isNeedCode) {//设置不可点击
            ViewClickUtil.setViewClickable(btnLogin, false);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void getImageCode(String code) {
        ivImagecode.setBackground(PicCodeUtil.byteToDrawable(code));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(RegisterEvent event) {
        if (event != null) {
            if (event.getPhone() != null && mEditPhone != null)
                mEditPhone.setText(event.getPhone());
        }
    }

    /**
     * 正常跳转
     *
     * @param context
     * @param typeToNormal
     */
    public static void normalActivity(Context context, int typeToNormal) {
        Intent newIntent = new Intent(context, LoginActivity.class);
        mSkip_type = typeToNormal;
        context.startActivity(newIntent);
    }

    /**
     * 跳转其他页activity
     *
     * @param context
     * @param toA
     * @param activity
     */
    public static void gotoActivity(Context context, int toA, Class<?> activity) {
        Intent newIntent = new Intent(context, LoginActivity.class);
        mSkip_type = toA;
        toActivity = activity;
        context.startActivity(newIntent);
    }

    /**
     * 跳转主页
     *
     * @param context
     * @param toA
     */
    public static void gotoMainMeActivity(Context context, int toA) {
        Intent newIntent = new Intent(context, LoginActivity.class);
        mSkip_type = toA;
        context.startActivity(newIntent);
    }


    @Override
    public void onBackPressed() {
        switch (mSkip_type) {
            case FinalConstant.login_type_normal:
                break;
            case FinalConstant.login_type_to_activity:
                if (sharedPreferencesUtils.getLoginStatus() && toActivity != null) {
                    IntentUtils.gotoActivity(mContext, toActivity);
                }
                break;
            case FinalConstant.login_type_to_meCenter:
                if (sharedPreferencesUtils.getLoginStatus()) {
                    IntentUtils.gotoMainActivity(mContext, FinalConstant.MAIN_CENTER_TYPE);
                } else {
                    IntentUtils.gotoMainActivity(mContext, FinalConstant.MAIN_HOME_TYPE);
                }
                break;
        }
        hideSoftKeyboard();
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }

    @Override
    public void setIsEmptyPort(View v, boolean isEmpty) {
        switch (v.getId()) {
            case R.id.edit_password:
                isPasswordEmpty = isEmpty;
                break;
            case R.id.edit_phone:
                isPhoneEmpty = isEmpty;
                break;
            case R.id.edit_imagecode:
                isImageEmpty = isEmpty;
                break;
        }
        if (isPasswordEmpty && isPhoneEmpty) {
            if (isNeedCode) {//需要检测验证码
                if (isImageEmpty) {
                    ViewClickUtil.setViewClickable(btnLogin, true);
                } else {
                    ViewClickUtil.setViewClickable(btnLogin, false);
                }
            } else {
                ViewClickUtil.setViewClickable(btnLogin, true);
            }
        } else {
            ViewClickUtil.setViewClickable(btnLogin, false);
        }
    }
}

