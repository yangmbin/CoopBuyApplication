package com.coopbuy.mall.ui.module.center.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.FinalConstant;
import com.coopbuy.mall.utils.IntentUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    //控制activity跳转类型
    private static int mSkip_type = FinalConstant.login_type_normal;//默认正常跳转
    private static int mOnclickType=-1;
    /**
     * 账号输入
     */
    @Bind(R.id.edit_phone)
    EditText mEditPhone;
    /**
     * 账号清除
     */
    @Bind(R.id.iv_phone_clear)
    ImageView mIvPhoneClear;
    /**
     * 密码输入
     */
    @Bind(R.id.edit_password)
    EditText mEditPassword;
    /**
     * 密码清理
     */
    @Bind(R.id.iv_password_clear)
    ImageView mIvPasswordClear;
    /**
     * 密码是否显示
     */
    @Bind(R.id.iv_password_visible)
    ImageView mIvPasswordShow;
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        //下划线
        mTvRegister.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTvRegister.getPaint().setAntiAlias(true);
        mTvForgetPassword.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTvForgetPassword.getPaint().setAntiAlias(true);
        setTitle(getString(R.string.title_login));

    }

    @OnClick({R.id.iv_phone_clear, R.id.iv_password_clear, R.id.iv_password_visible, R.id.btn_login, R.id.tv_register, R.id.tv_forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_phone_clear:

                break;
            case R.id.iv_password_clear:

                break;
            case R.id.iv_password_visible:

                break;
            case R.id.btn_login:

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
     * 创建intent 控制从mainActivity跳转至当前页面
     *
     * @param context    上下文
     * @return
     */
    public static Intent newIntentMeActivity(Context context, int type, int clickType) {
        Intent newIntent = new Intent(context, LoginActivity.class);
        mSkip_type=type;
        mOnclickType = clickType;
        context.startActivity(newIntent);
        return newIntent;
    }
}

