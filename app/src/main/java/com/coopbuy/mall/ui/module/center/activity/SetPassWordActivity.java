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
import com.coopbuy.mall.ui.module.center.port.IsEmptyPort;
import com.coopbuy.mall.ui.module.center.presenter.SetPasswordPresenter;
import com.coopbuy.mall.ui.module.center.view.SetPassword_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.utils.ViewClickUtil;
import com.coopbuy.mall.widget.tab.MyEditText;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 初次设置密码 和修改密码一样的界面 到时设置逻辑就行了 2017年9月29日10:13:39
 */
public class SetPassWordActivity extends BaseActivity<SetPasswordPresenter, SetPasswordModel> implements SetPassword_IView, IsEmptyPort {
    @Bind(R.id.rl_agian_password)
    RelativeLayout rlAgianPassword;
    @Bind(R.id.btn_next)
    Button btnNext;
    @Bind(R.id.edt_pwd)
    MyEditText edtPwd;
    @Bind(R.id.edt_again_pwd)
    MyEditText edtAgainPwd;
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
        edtPwd.setTextPasswordVisible(false);
        edtAgainPwd.setTextPasswordVisible(false);
        edtAgainPwd.setIsEmptyPort(this);
        edtPwd.setIsEmptyPort(this);
        setTitle("设置密码");
        if (null != getIntent()) {
            type = getIntent().getStringExtra(IntentUtils.PARAM1);
            if (type.equals(Constants.REGISTER_TYPE)) {//只有一次设置密码
                regrequest = (RegisterRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
                rlAgianPassword.setVisibility(View.GONE);
            } else {//有两次填写密码 包括了找回密码 和修改密码
                rlAgianPassword.setVisibility(View.VISIBLE);
                edtPwd.setHintText("请输入新密码");
                cfpRequest = (ChangeAndForgetPwdRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
            }
        }
    }

    @OnClick({  R.id.btn_next, R.id.cb_again_visible, R.id.cb_visible})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cb_visible:
                edtPwd.setTextPasswordVisible(cbVisible.isChecked());
                break;
            case R.id.cb_again_visible:
                edtAgainPwd.setTextPasswordVisible(cbAgainVisible.isChecked());
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

    @Override
    public void setIsEmptyPort(View v, boolean isEmpty) {
        switch (v.getId()) {
            case R.id.edt_pwd:
                isPwdEmpty = isEmpty;
                break;
            case R.id.edt_again_pwd:
                isAgainPwdEmpty = isEmpty;
                break;
        }
        if (isPwdEmpty && isAgainPwdEmpty) {
            ViewClickUtil.setViewClickable(btnNext, true);
        } else {
            ViewClickUtil.setViewClickable(btnNext, false);
        }
    }
}
