package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.request.RegisterRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.RegisterEvent;
import com.coopbuy.mall.ui.module.center.model.RegisterModel;
import com.coopbuy.mall.ui.module.center.port.IsEmptyPort;
import com.coopbuy.mall.ui.module.center.presenter.RegisterPresenter;
import com.coopbuy.mall.ui.module.center.view.Register_IView;
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

public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterModel> implements Register_IView, IsEmptyPort {
    @Bind(R.id.edt_phone)
    MyEditText edtPhone;
    @Bind(R.id.edt_code)
    MyEditText edtCode;
    @Bind(R.id.cb_agree)
    CheckBox cbAgree;
    @Bind(R.id.btn_next)
    Button btnNext;
    @Bind(R.id.tv_get_code)
    TextView tvGetCode;

    private boolean isPhoneEmpty = false;
    private boolean isCodeEmpty = false;
    //默认同意协议
    private boolean isAgree = true;

    private String mPhone = "";
    //服务器的返回的code
    private String mCode = "";
    private String smscode = "";

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
        EventBusInstance.getInstance().registerEvent(this);
        setTitle(R.string.title_regist);
        edtCode.setIsEmptyPort(this);
        edtPhone.setIsEmptyPort(this);
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
    public void onTimeTick(long time) {
        if (null != tvGetCode) {
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
        mCode = code;
    }

    @OnClick({R.id.tv_get_code, R.id.cb_agree, R.id.tv_protocol, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_get_code:
                if (checkPhone()) {
                    mPresenter.getSMSCode(mPhone);
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
                IntentUtils.gotoActivity(this, MegHtmlActivity.class, "http://photo.cankaoxiaoxi.com/bd/2017/0603/2070883.shtml");
                break;
            case R.id.btn_next:
                if (checkPhoneAndPwd()) {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setPhone(mPhone);
                    registerRequest.setCode(mCode);
                    registerRequest.setVerificationCode(smscode);
                    IntentUtils.gotoActivity(this, SetPassWordActivity.class, registerRequest, Constants.REGISTER_TYPE);
                }
                break;
        }
    }

    private boolean checkPhoneAndPwd() {
        mPhone = edtPhone.getText().toString().trim();
        smscode = edtCode.getText().toString().trim();
        if (CommonUtils.isEmpty(mPhone)) {
            ToastUtils.toastShort(getString(R.string.lab_login_enter_phone));
            return false;
        }
        if (!CommonUtils.isMobileNO(mPhone)) {
            ToastUtils.toastShort(getString(R.string.label_phone_iseorr));
            return false;
        }
        if (CommonUtils.isEmpty(smscode)) {
            ToastUtils.toastShort("验证码不能为空");
            return false;
        }
        if (CommonUtils.isEmpty(mCode)) {
            ToastUtils.toastShort("你还没有获取验证码");
            return false;
        }
        if (!isAgree) {
            ToastUtils.toastShort("你还没有同意相关协议");
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(RegisterEvent event) {
        if (event != null) {
            this.finish();
        }
    }

    @Override
    public void setIsEmptyPort(View v, boolean isEmpty) {
        switch (v.getId()) {
            case R.id.edt_code:
                isCodeEmpty = isEmpty;
                break;
            case R.id.edt_phone:
                isPhoneEmpty = isEmpty;
                break;
        }
        if (isCodeEmpty && isPhoneEmpty) {
            ViewClickUtil.setViewClickable(btnNext, true);
        } else {
            ViewClickUtil.setViewClickable(btnNext, false);
        }
    }

}
