package com.coopbuy.mall.ui.module.center.activity;

import android.widget.EditText;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class SuggestionActivity extends BaseActivity {

    @Bind(R.id.edt_suggestion_mesg)
    EditText edtSuggestionMesg;
    @Bind(R.id.tv_test_length)
    TextView tvTestLength;
    @Bind(R.id.edt_name)
    EditText edtName;
    @Bind(R.id.edt_phone)
    EditText edtPhone;

    @Override
    public int getLayoutId() {
        return R.layout.activity_suggestion;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle(R.string.title_suggestion);
    }

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
    }
}
