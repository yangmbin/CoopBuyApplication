package com.coopbuy.mall.ui.module.center.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.request.ChangeAndForgetPwdRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.RegisterModel;
import com.coopbuy.mall.ui.module.center.presenter.RegisterPresenter;
import com.coopbuy.mall.ui.module.center.view.Register_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author csn
 * @time 2017/10/16 0016 20:20
 * @content 在线修改密码  那忘记密码呢
 */
public class ForgetPwdActivity extends BaseActivity<RegisterPresenter, RegisterModel> implements Register_IView {


    @Bind(R.id.tv_phone)
    TextView tvPhone;
    @Bind(R.id.rl_change_pwd)
    RelativeLayout rlChangePwd;
    @Bind(R.id.edt_forget_phone)
    EditText edtForgetPhone;
    @Bind(R.id.iv_forgetcode_clear)
    ImageView ivForgetcodeClear;
    @Bind(R.id.rl_forget_pwd)
    RelativeLayout rlForgetPwd;
    @Bind(R.id.edt_code)
    EditText edtCode;
    @Bind(R.id.iv_code_clear)
    ImageView ivCodeClear;
    @Bind(R.id.tv_get_code)
    TextView tvGetCode;
    @Bind(R.id.btn_next)
    Button btnNext;
    private String type;

    private boolean isForgetPwdEmpty = false;
    private boolean isCodeEmpty = false;
    private String mPhone;
    private String mCode;
    private String smsCode;

    @Override
    public int getLayoutId() {
        return R.layout.activity_forget_pwd;
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
        if (null != getIntent()) {
            type = getIntent().getStringExtra(IntentUtils.PARAM1);
            ivForgetcodeClear.setVisibility(View.GONE);
            ivCodeClear.setVisibility(View.GONE);
            if (type.equals(Constants.FORGET_TYPE)) {
                setTitle("找回密码");
                rlChangePwd.setVisibility(View.GONE);
                rlForgetPwd.setVisibility(View.VISIBLE);
            } else {
                setTitle("在线更改密码");
                tvPhone.setText(sharedPreferencesUtils.getUserPhone());
                rlChangePwd.setVisibility(View.VISIBLE);
                rlForgetPwd.setVisibility(View.GONE);
            }
        }
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
        edtForgetPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    ivForgetcodeClear.setVisibility(View.VISIBLE);
                } else {
                    ivForgetcodeClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isForgetPwdEmpty = true;
                } else {
                    isForgetPwdEmpty = false;
                }
                setBtnClickState();
            }
        });
    }

    /**
     * 设置btn的点击状态
     */
    private void setBtnClickState() {
        if (isCodeEmpty) {
            if (type.equals(Constants.FORGET_TYPE)) {//忘记密码需要判断
                if (isForgetPwdEmpty) {
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

    @Override
    public void onTimeTick(long time) {
        if (tvGetCode != null) {
            tvGetCode.setFocusable(false);
            tvGetCode.setClickable(false);
            long i = 1000;
            String timeShowStr = String.format(getResources().getString(R.string.seconds_later_can_get_vcode), time / i);
            tvGetCode.setText(getString(R.string.label_again_get) + timeShowStr + "s)");
            tvGetCode.setTextColor(getResources().getColor(R.color.auxiliary_text_blue_gray));
        }
    }

    @Override
    public void onTimeFinish() {
        if (null != tvGetCode) {
            tvGetCode.setText(getResources().getString(R.string.register_code_agin));
            tvGetCode.setFocusable(true);
            tvGetCode.setClickable(true);
            tvGetCode.setTextColor(getResources().getColor(R.color.theme_text_lab_black));
        }
    }

    @Override
    public void smsCode(String code) {
        this.mCode = code;
    }


    @OnClick({R.id.iv_forgetcode_clear, R.id.iv_code_clear, R.id.tv_get_code, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_forgetcode_clear:
                edtForgetPhone.setText("");
                break;
            case R.id.iv_code_clear:
                edtCode.setText("");
                break;
            case R.id.tv_get_code:
                if (checkPhoneAndPwd("getcode")) {
                    mPresenter.getSMSCodeUpdate(mPhone);
                }
                break;
            case R.id.btn_next:
                if (checkPhoneAndPwd("next")) {
                    ChangeAndForgetPwdRequest request = new ChangeAndForgetPwdRequest();
                    request.setPhone(mPhone);
                    request.setCode(mCode);
                    request.setVerificationCode(smsCode);
                    IntentUtils.gotoActivity(this, SetPassWordActivity.class, request, type);
                }
                break;
        }
    }

    private boolean checkPhoneAndPwd(String type) {
        mPhone = edtForgetPhone.getText().toString().trim();
        smsCode = edtCode.getText().toString().trim();
        if (CommonUtils.isEmpty(mPhone)) {
            ToastUtils.toastShort(getString(R.string.lab_login_enter_phone));
            return false;
        }
        if (!CommonUtils.isMobileNO(mPhone)) {
            ToastUtils.toastShort(getString(R.string.label_phone_iseorr));
            return false;
        }

        if (type.equals("next")) {
            if (CommonUtils.isEmpty(mCode)) {
                ToastUtils.toastShort("你还没有获取验证码");
                return false;
            }
            if (CommonUtils.isEmpty(smsCode)) {
                ToastUtils.toastShort("验证码不能为空");
                return false;
            }
        }
        return true;
    }
}
