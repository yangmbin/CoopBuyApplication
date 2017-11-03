package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CheckPhoneReponse;
import com.coopbuy.mall.api.reponse.PhoneRechargeListReponse;
import com.coopbuy.mall.api.request.CheckPhoneRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.PhoneRechargeAdapter;
import com.coopbuy.mall.ui.module.center.model.PhoneRechargeModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.PhoneRechargePresenter;
import com.coopbuy.mall.ui.module.center.view.PhoneRecharge_IView;
import com.coopbuy.mall.utils.CommonUtils;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneRechargeActivity extends BaseActivity<PhoneRechargePresenter, PhoneRechargeModel> implements PhoneRecharge_IView, FootMarkPort {
    @Bind(R.id.edit_phone)
    EditText editPhone;
    @Bind(R.id.tv_charge)
    TextView tvCharge;
    @Bind(R.id.tv_area)
    TextView mArea;
    @Bind(R.id.swipe_target)
    RecyclerView swipeTarget;
    @Bind(R.id.tv_charge_number)
    TextView tvChargeNumber;
    private String mPhone;
    private List<PhoneRechargeListReponse> data;
    private PhoneRechargeAdapter adapter;
    private CheckPhoneRequest request;

    @Override
    public int getLayoutId() {
        return R.layout.activity_phone_charge;
    }

    @Override
    public void initModel() {
        mModel = new PhoneRechargeModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new PhoneRechargePresenter(this, mModel, this);
        mPresenter.getMobilList();
    }

    @Override
    public void initView() {
        setTitle(R.string.title_charge);
        request = new CheckPhoneRequest();
        initRey();
        setInputListener();
    }

    private void setInputListener() {
        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 11) {
                    if (checkPhone()) {
                        request.setPhone(mPhone);
                        mPresenter.getCheckPhoneData(request);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private boolean checkPhone() {
        mPhone = editPhone.getText().toString().trim();
        setArea("");
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

    private void initRey() {
        data = new ArrayList<>();
        adapter = new PhoneRechargeAdapter(this, data, this);
        swipeTarget.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        swipeTarget.setAdapter(adapter);
    }


    @Override
    public void getMobilData(List<PhoneRechargeListReponse> data) {
        request.setCardId(data.get(0).getCardId());
        adapter.addData(data);
    }

    @Override
    public void getCheckPhoneData(CheckPhoneReponse bean) {
        setArea(bean.getArea());
    }

    private void setArea(String msg) {
        mArea.setText(msg);
    }

    @Override
    public void openDetial(int postion) {
        tvChargeNumber.setText("支付：" + data.get(postion).getSalePrice() + "元");
        request.setCardId(data.get(postion).getCardId());
    }


    @OnClick({R.id.ll_charge_cancel, R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_charge_cancel:
                editPhone.setText("");

                break;
            case R.id.btn_complete:
                break;
        }
    }
}
