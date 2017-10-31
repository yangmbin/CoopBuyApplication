package com.coopbuy.mall.ui.module.center.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.request.SuggestRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.SuggestModel;
import com.coopbuy.mall.ui.module.center.presenter.SuggestPresenter;
import com.coopbuy.mall.ui.module.center.view.Suggest_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.ToastUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class SuggestionActivity extends BaseActivity<SuggestPresenter, SuggestModel> implements Suggest_IView {
    @Bind(R.id.edt_suggestion_mesg)
    EditText edtSuggestionMesg;
    @Bind(R.id.tv_test_length)
    TextView tvTestLength;
    @Bind(R.id.edt_name)
    EditText edtName;
    @Bind(R.id.edt_phone)
    EditText edtPhone;

    private String mName;
    private String mContent;
    private String mPhone;

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
}
