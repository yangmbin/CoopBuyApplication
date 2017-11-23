package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.request.SuggestRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.SuggestModel;
import com.coopbuy.mall.ui.module.center.port.IsEmptyPort;
import com.coopbuy.mall.ui.module.center.presenter.SuggestPresenter;
import com.coopbuy.mall.ui.module.center.view.Suggest_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.utils.ViewClickUtil;
import com.coopbuy.mall.widget.tab.MyEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuggestionActivity extends BaseActivity<SuggestPresenter, SuggestModel> implements Suggest_IView, IsEmptyPort {
    @Bind(R.id.edt_suggestion_mesg)
    EditText edtSuggestionMesg;
    @Bind(R.id.tv_test_length)
    TextView tvTestLength;
    @Bind(R.id.edt_name)
    MyEditText edtName;
    @Bind(R.id.edt_phone)
    MyEditText edtPhone;
    @Bind(R.id.btn_complete)
    Button btnComplete;

    private String mName;
    private String mContent;
    private String mPhone;
    private boolean isNameEmpty = false;
    private boolean isPhoneEmpty = false;
    private boolean isContentEmpty = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_suggestion;
    }

    @Override
    public void initModel() {
        mModel = new SuggestModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new SuggestPresenter(this, mModel, this);
    }


    @Override
    public void initView() {
        setTitle(R.string.title_suggestion);
        setInputListener();
        edtPhone.setIsEmptyPort(this);
        edtName.setIsEmptyPort(this);
    }

    private void setInputListener() {
        edtSuggestionMesg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 200) {
                    ToastUtils.toastLong("最多只能输入200个字");
                }
                tvTestLength.setText((200 - charSequence.length()) + "/200");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    isContentEmpty = true;
                } else {
                    isContentEmpty = false;
                }
                setonClick();
            }
        });
    }

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
        if (checkMesg()) {
            SuggestRequest request = new SuggestRequest();
            request.setRealName(mName);
            request.setSuggestContent(mContent);
            request.setTel(mPhone);
            mPresenter.suggest(request);
        }
    }

    private boolean checkMesg() {
        mContent = edtSuggestionMesg.getText().toString().trim();
        mName = edtName.getText().toString().trim();
        mPhone = edtPhone.getText().toString().trim();
        if (CommonUtils.isEmpty(mContent)) {
            ToastUtils.toastShort("内容不能为空");
            return false;
        }
        if (CommonUtils.isEmpty(mName)) {
            ToastUtils.toastShort("姓名不能为空");
            return false;
        }
        if (CommonUtils.isEmpty(mPhone)) {
            ToastUtils.toastShort("电话不能为空");
            return false;
        }
        return true;
    }

    @Override
    public void success() {
        finish();
    }

    @Override
    public void setIsEmptyPort(View v, boolean isEmpty) {
        switch (v.getId()) {
            case R.id.edt_name:
                isNameEmpty = isEmpty;
                break;
            case R.id.edt_phone:
                isPhoneEmpty = isEmpty;
                break;
        }
      setonClick();
    }
    private void setonClick(){
        if (isPhoneEmpty && isNameEmpty && isContentEmpty) {
            ViewClickUtil.setViewClickable(btnComplete, true);
        } else {
            ViewClickUtil.setViewClickable(btnComplete, false);
        }
    }
}
