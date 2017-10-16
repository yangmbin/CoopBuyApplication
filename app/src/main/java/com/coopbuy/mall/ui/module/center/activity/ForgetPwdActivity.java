package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.RegisterModel;
import com.coopbuy.mall.ui.module.center.presenter.RegisterPresenter;
import com.coopbuy.mall.ui.module.center.view.Register_IView;

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
    @Bind(R.id.edt_code)
    EditText edtCode;
    @Bind(R.id.iv_code_clear)
    ImageView ivCodeClear;
    @Bind(R.id.tv_get_code)
    TextView tvGetCode;
    @Bind(R.id.btn_next)
    Button btnNext;

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
        setTitle("在线更改密码");
    }


    @OnClick({R.id.iv_code_clear, R.id.tv_get_code, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_code_clear:
                edtCode.setText("");
                break;
            case R.id.tv_get_code:

                break;
            case R.id.btn_next:

                break;
        }
    }

    @Override
    public void onTimeTick(long time) {

    }

    @Override
    public void onTimeFinish() {

    }

    @Override
    public void smsCode(String code) {

    }
}
