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
    private RegisterRequest request;
    private String type;
    private String mPwd = "";
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
        if (null != getIntent()) {
            type = getIntent().getStringExtra(IntentUtils.PARAM1);
            if (type.equals(Constants.REGISTER_TYPE)) {
                request = (RegisterRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
                setTitle("设置密码");
                rlAgianPassword.setVisibility(View.GONE);
            } else {
                setTitle("修改密码");
                rlAgianPassword.setVisibility(View.VISIBLE);
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
                        request.setPassword(mPwd);
                        mPresenter.register(request);
                    }
                } else {//修改密码使用

                }
                break;
        }
    }

    @Override
    public void registerSuccess() {
        this.finish();
        EventBusInstance.getInstance().post(new RegisterEvent());
    }

    private boolean checkPhoneAndPwd() {
        mPwd = edtPwd.getText().toString().trim();
        if (CommonUtils.isEmpty(mPwd)) {
            ToastUtils.toastShort("密码不能为空");
            return false;
        }
        if (mPwd.length() < 6) {
            ToastUtils.toastShort("密码长度不满足要求");
            return false;
        }
        return true;
    }
}
