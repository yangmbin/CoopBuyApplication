package com.coopbuy.mall.ui.module.center.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.request.ChangeAndForgetPwdRequest;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.RegisterEvent;
import com.coopbuy.mall.ui.module.center.model.SetPasswordModel;
import com.coopbuy.mall.ui.module.center.presenter.SetPasswordPresenter;
import com.coopbuy.mall.ui.module.center.view.SetPassword_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 初次设置密码 和修改密码一样的界面 到时设置逻辑就行了 2017年9月29日10:13:39
 */
public class SetPassWordActivity extends BaseActivity<SetPasswordPresenter, SetPasswordModel> implements SetPassword_IView {

    @Bind(R.id.iv_password_clear)
    ImageView ivPasswordClear;
    @Bind(R.id.iv_password_again_clear)
    ImageView ivPasswordAgainClear;
    @Bind(R.id.rl_agian_password)
    RelativeLayout rlAgianPassword;
    @Bind(R.id.btn_next)
    Button btnNext;
    @Bind(R.id.edt_pwd)
    EditText edtPwd;
    @Bind(R.id.edt_again_pwd)
    EditText edtAgainPwd;
    @Bind(R.id.cb_visible)
    CheckBox cbVisible;
    @Bind(R.id.cb_again_visible)
    CheckBox cbAgainVisible;
    private RegisterRequest regrequest;//注册密码
    private ChangeAndForgetPwdRequest cfpRequest;//修改密码 和忘记密码
    private String type;
    private String mPwd = "";
    private String mAgainPwd = "";
    private boolean isPwdEmpty = false;
    private boolean isAgainPwdEmpty = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_pass_worder;
    }

    @Override
    public void initModel() {
        mModel = new SetPasswordModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new SetPasswordPresenter(this, mModel, this);
    }

    @Override
    public void initView() {
        ivPasswordClear.setVisibility(View.GONE);
        ivPasswordAgainClear.setVisibility(View.GONE);
        setTitle("设置密码");
        if (null != getIntent()) {
            type = getIntent().getStringExtra(IntentUtils.PARAM1);
            if (type.equals(Constants.REGISTER_TYPE)) {//只有一次设置密码
                regrequest = (RegisterRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
                rlAgianPassword.setVisibility(View.GONE);
            } else {//有两次填写密码 包括了找回密码 和修改密码
                rlAgianPassword.setVisibility(View.VISIBLE);
                edtPwd.setHint("请输入新密码");
                cfpRequest = (ChangeAndForgetPwdRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
            }
        }
        setInputListener();
    }

    private void setInputListener() {
        edtPwd.addTextChangedListener(new TextWatcher() {
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
                    isPwdEmpty = true;
                } else {
                    isPwdEmpty = false;
                }
                setBtnClickState();
            }
        });
        edtAgainPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    ivPasswordAgainClear.setVisibility(View.VISIBLE);
                } else {
                    ivPasswordAgainClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isAgainPwdEmpty = true;
                } else {
                    isAgainPwdEmpty = false;
                }
                setBtnClickState();
            }
        });
    }

    /**
     * 设置btn的点击状态
     */
    private void setBtnClickState() {
        if (isPwdEmpty) {
            if (!type.equals(Constants.REGISTER_TYPE)) {//修改密码
                if (isAgainPwdEmpty) {
                    btnNext.setClickable(true);
                    btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
                } else {
                    btnNext.setClickable(false);
                    btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
                }
            } else {
                btnNext.setClickable(true);
                btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
            }

        } else {
            btnNext.setClickable(false);
            btnNext.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
        }
    }

    @OnClick({R.id.iv_password_clear, R.id.iv_password_again_clear, R.id.btn_next, R.id.cb_again_visible, R.id.cb_visible})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cb_visible:
                if (cbVisible.isChecked()) {
                    edtPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    edtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.cb_again_visible:
                if (cbAgainVisible.isChecked()) {
                    edtAgainPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    edtAgainPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.iv_password_clear:
                edtPwd.setText("");
                break;
            case R.id.iv_password_again_clear:
                edtAgainPwd.setText("");
                break;
            case R.id.btn_next:
                if (type.equals(Constants.REGISTER_TYPE)) {//注册使用
                    if (checkPhoneAndPwd()) {
                        regrequest.setPassword(mPwd);
                        mPresenter.register(regrequest);
                    }
                } else {//修改密码使用
                    if (checkPhoneAndPwd()) {
                        cfpRequest.setNewPassword(mAgainPwd);
                        mPresenter.updatePwd(cfpRequest);
                    }
                }
                break;
        }
    }

    @Override
    public void registerSuccess() {
        RegisterEvent event = new RegisterEvent();
        if (type.equals(Constants.REGISTER_TYPE)) {
            event.setPhone(regrequest.getPhone());
        } else if (type.equals(Constants.FORGET_TYPE)) {
            event.setPhone(cfpRequest.getPhone());
        } else {
            //修改密码 需要重新登录 清除对应的数据
            sharedPreferencesUtils.clearUserData();
            IntentUtils.gotoActivity(this, LoginActivity.class);
        }
        EventBusInstance.getInstance().post(event);
        this.finish();
    }

    private boolean checkPhoneAndPwd() {
        mPwd = edtPwd.getText().toString().trim();
        mAgainPwd = edtAgainPwd.getText().toString().trim();
        if (CommonUtils.isEmpty(mPwd)) {
            ToastUtils.toastShort("密码不能为空");
            return false;
        }
        if (mPwd.length() < 6) {
            ToastUtils.toastShort("密码长度不满足要求");
            return false;
        }
        if (type.equals(Constants.FORGET_TYPE)) {
            if (CommonUtils.isEmpty(mAgainPwd)) {
                ToastUtils.toastShort("密码不能为空");
                return false;
            }
            if (mAgainPwd.length() < 6) {
                ToastUtils.toastShort("密码长度不满足要求");
                return false;
            }
            if (!mPwd.equals(mAgainPwd)) {
                ToastUtils.toastShort("两次密码不一样");
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }
}
